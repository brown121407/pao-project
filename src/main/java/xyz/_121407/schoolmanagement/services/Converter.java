package xyz._121407.schoolmanagement.services;

import xyz._121407.schoolmanagement.entities.RoomType;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Converter {
    private static Converter instance;
    private final Map<Class<?>, Function<String, Object>> conversions = new HashMap<>();

    private Converter() {
        conversions.put(Integer.class, Integer::parseInt);
        conversions.put(RoomType.class, RoomType::valueOf);
        conversions.put(LocalDate.class, LocalDate::parse);
    }

    public static Converter getInstance() {
        if (instance == null) {
            instance = new Converter();
        }

        return instance;
    }

    public <T> T convert(String obj, Class<T> resType) {
        if (resType == String.class) {
            return (T) obj;
        }

        return (T) conversions.get(resType).apply(obj);
    }
}
