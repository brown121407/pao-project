package xyz._121407.schoolmanagement.services;

import xyz._121407.schoolmanagement.annotations.CsvWritable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.stream.Collectors;

public class EntityWriter {
    private static EntityWriter instance;

    private final SerializationConfig serializationConfig = SerializationConfig.getInstance();

    private EntityWriter() {}

    public static EntityWriter getInstance() {
        if (instance == null) {
            instance = new EntityWriter();
        }

        return instance;
    }

    public <T> void writeAll(Set<T> objs) throws IOException {
        if (objs.size() == 0) {
            return;
        }

        // Empty file
        new FileWriter(serializationConfig.getPath(objs.toArray()[0].getClass())).close();

        for (var obj : objs) {
            writeOne(obj);
        }
    }

    public <T> void writeOne(T obj) throws IOException {
        var writerMethods = Arrays.stream(obj.getClass().getMethods())
                .filter(m -> m.isAnnotationPresent(CsvWritable.class))
                // Sort to guarantee same-order serialization
                .sorted(Comparator.comparing(m -> m.getAnnotation(CsvWritable.class).field()))
                .toList();

        var file = new File(serializationConfig.getPath(obj.getClass()));
        var writer = new FileWriter(file, true);

        if (file.length() == 0) {
            var header = writerMethods.stream()
                    .map(m -> m.getAnnotation(CsvWritable.class).field())
                    .collect(Collectors.joining(serializationConfig.getDelimiter()));
            writer.append(header);
            writer.append('\n');
        }

        var row = writerMethods.stream().map(m -> {
            try {
                return m.invoke(obj).toString();
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                return "ERROR: " + e.getMessage();
            }
        }).collect(Collectors.joining(serializationConfig.getDelimiter()));

        writer.append(row);
        writer.append('\n');
        writer.flush();
        writer.close();
    }
}
