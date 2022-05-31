package xyz._121407.schoolmanagement.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reflection {
    // Adapted from: https://stackoverflow.com/a/2405757, Copyright 2010 Esko Luontola
    // Licensed under CC BY-SA 3.0
    public static List<Field> getAllFields(Class<?> type) {
        List<Field> fields = new ArrayList<>();
        for (Class<?> c = type; c != null; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
        }
        return fields;
    }
}
