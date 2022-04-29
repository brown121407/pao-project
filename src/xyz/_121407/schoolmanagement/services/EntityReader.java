package xyz._121407.schoolmanagement.services;

import xyz._121407.schoolmanagement.annotations.CsvReadable;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntityReader {
    private static EntityReader instance;

    private EntityReader() {}

    public static EntityReader getInstance() {
        if (instance == null) {
            instance = new EntityReader();
        }

        return instance;
    }

    public <T> List<T> read(Class<T> klass) throws IOException {
        var entities = new ArrayList<T>();
        var path = SerializationConfig.getInstance().getPath(klass);

        if (!Files.exists(Path.of(path))) {
            return entities;
        }

        try (var reader = new BufferedReader(new FileReader(path))) {
            var header = reader.readLine().split(SerializationConfig.getInstance().getDelimiter());

            String line;
            while ((line = reader.readLine()) != null) {
                var fieldValues = line.split(SerializationConfig.getInstance().getDelimiter());
                var methods = Arrays.stream(klass.getMethods())
                        .filter(m -> {
                            var annotation = m.getAnnotation(CsvReadable.class);

                            if (annotation == null) {
                                return false;
                            }

                            return Arrays.stream(header).anyMatch(x -> x.equals(annotation.field()));
                        })
                        .toList();

                var entity = klass.getConstructor().newInstance();

                for (var i = 0; i < header.length; i++) {
                    var field = header[i];
                    var method = methods.stream()
                            .filter(m -> m.getAnnotation(CsvReadable.class).field().equals(field))
                            .findFirst();

                    if (method.isPresent()) {
                        var paramClass = method.get().getParameterTypes()[0];
                        var value = Converter.getInstance().convert(fieldValues[i], paramClass);
                        method.get().invoke(entity, value);
                    }
                }

                entities.add(entity);
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            // TODO
            e.printStackTrace();
        }

        return entities;
    }
}
