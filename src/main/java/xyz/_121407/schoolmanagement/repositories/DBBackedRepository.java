package xyz._121407.schoolmanagement.repositories;

import xyz._121407.schoolmanagement.annotations.Field;
import xyz._121407.schoolmanagement.annotations.Table;
import xyz._121407.schoolmanagement.entities.Identifiable;
import xyz._121407.schoolmanagement.exceptions.RepositoryException;
import xyz._121407.schoolmanagement.services.Database;

import java.sql.SQLException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DBBackedRepository<T extends Identifiable> implements IRepository<T> {
    private Class<T> klass;

    public DBBackedRepository(Class<T> klass) {
        if (!klass.isAnnotationPresent(Table.class)) {
            throw new RuntimeException(klass.getName() + " is not annotated with " + Table.class.getName());
        }

        this.klass = klass;
    }

    @Override
    public void seed(List<T> entities) {

    }

    @Override
    public void create(T obj) {
        var connection = Database.getConnection();

        var builder = new StringBuilder();
        builder.append("INSERT INTO ").append(klass.getSimpleName());

        Map<String, String> values = new HashMap<>();
        for (var field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (!field.isAnnotationPresent(Field.class)) {
                continue;
            }

            var fieldProps = field.getAnnotation(Field.class);
            if (!fieldProps.primaryKey()) {
                try {
                    if (field.getType().equals(String.class) || field.getType().isEnum()) {
                        values.put(field.getName(), "'" + field.get(obj).toString() + "'");
                    } else {
                        values.put(field.getName(), field.get(obj).toString());
                    }
                } catch (IllegalAccessException exception) {
                    throw new RepositoryException(exception);
                }
            }
        }

        var entrySet = values.entrySet();
        var fieldNames = entrySet.stream().map(Map.Entry::getKey).collect(Collectors.joining(", "));
        var fieldValues = entrySet.stream().map(Map.Entry::getValue).collect(Collectors.joining(", "));

        builder.append("(");
        builder.append(fieldNames);
        builder.append(") VALUES (");
        builder.append(fieldValues);
        builder.append(")");

        try (var stmt = connection.createStatement()) {
            stmt.execute(builder.toString());
        } catch (SQLException exception) {
            throw new RepositoryException(exception);
        }
    }

    @Override
    public Set<T> getAll() {
        return null;
    }

    @Override
    public List<T> getAllSortedBy(Comparator<T> comparator) {
        return null;
    }

    @Override
    public T findFirst(Predicate<T> predicate) {
        return null;
    }

    @Override
    public Set<T> findAll(Predicate<T> predicate) {
        return null;
    }

    @Override
    public void update(T obj) {

    }

    @Override
    public void delete(int id) {

    }
}
