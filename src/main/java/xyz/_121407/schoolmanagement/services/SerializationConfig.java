package xyz._121407.schoolmanagement.services;

import java.util.HashMap;
import java.util.Map;

public class SerializationConfig {
    private static SerializationConfig instance;
    private final Map<Class<?>, String> paths = new HashMap<>();
    private String delimiter = ";";

    private SerializationConfig() {}

    public static SerializationConfig getInstance() {
        if (instance == null) {
            instance = new SerializationConfig();
        }

        return instance;
    }

    public <T> String getPath(Class<T> klass) {
        return paths.get(klass);
    }

    public <T> void setPath(Class<T> klass, String path) {
        paths.put(klass, path);
    }

    public String getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
}
