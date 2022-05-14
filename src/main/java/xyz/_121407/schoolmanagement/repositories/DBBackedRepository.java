package xyz._121407.schoolmanagement.repositories;

import xyz._121407.schoolmanagement.annotations.Field;
import xyz._121407.schoolmanagement.annotations.Table;
import xyz._121407.schoolmanagement.entities.Identifiable;
import xyz._121407.schoolmanagement.exceptions.RepositoryException;
import xyz._121407.schoolmanagement.services.Database;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class DBBackedRepository<T extends Identifiable> implements IRepository<T> {
    private final Class<T> klass;
    private final List<java.lang.reflect.Field> fields;

    public DBBackedRepository(Class<T> klass) {
        if (!klass.isAnnotationPresent(Table.class)) {
            throw new RuntimeException(klass.getName() + " is not annotated with " + Table.class.getName());
        }

        this.klass = klass;
        fields = Arrays.stream(klass.getDeclaredFields())
                .filter(x -> x.isAnnotationPresent(Field.class))
                .collect(Collectors.toList());
    }

    @Override
    public void seed(List<T> entities) {
        for (var entity : entities) {
            create(entity);
        }
    }

    @Override
    public void create(T obj) {
        var connection = Database.getConnection();

        var builder = new StringBuilder();
        builder.append("INSERT INTO ").append(klass.getSimpleName());

        Map<String, String> values = getFieldValues(obj);

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
        Set<T> entities = new HashSet<>();
        var connection = Database.getConnection();

        try (var stmt = connection.createStatement()) {
            var res = stmt.executeQuery("SELECT * FROM " + klass.getSimpleName());

            while (res.next()) {
                var entity = klass.getConstructor().newInstance();

                for (var field : fields) {
                    field.setAccessible(true);

                    if (field.getType().equals(int.class) || field.getType().equals(Integer.class)) {
                        field.set(entity, res.getInt(field.getName()));
                    } else if (field.getType().equals(String.class) || field.getType().isEnum()) {
                        field.set(entity, res.getString(field.getName()));
                    } else {
                        throw new RepositoryException("Field type not recognized: " + field.getType().getName());
                    }
                }

                entities.add(entity);
            }
        } catch (SQLException | InvocationTargetException | InstantiationException
                | IllegalAccessException | NoSuchMethodException exception) {
            throw new RepositoryException(exception);
        }

        return entities;
    }

    @Override
    public List<T> getAllSortedBy(Comparator<T> comparator) {
        return getAll().stream().sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public T findFirst(Predicate<T> predicate) {
        return getAll().stream().filter(predicate).findFirst().orElse(null);
    }

    @Override
    public Set<T> findAll(Predicate<T> predicate) {
        return getAll().stream().filter(predicate).collect(Collectors.toSet());
    }

    @Override
    public void update(T obj) {
        var connection = Database.getConnection();

        var values = getFieldValues(obj);
        var builder = new StringBuilder();
        builder.append("UPDATE ")
                .append(klass.getSimpleName())
                .append(" SET ");

        var updates = values.entrySet().stream()
                .map(x -> x.getKey() + " = " + x.getValue())
                .collect(Collectors.joining(", "));

        builder.append(updates)
                .append(" WHERE id = ?");

        try (var stmt = connection.prepareStatement(builder.toString())) {
            stmt.setInt(1, obj.getId());

            stmt.executeUpdate();
        } catch (SQLException exception) {
            throw new RepositoryException(exception);
        }
    }

    @Override
    public void delete(int id) {
        var connection = Database.getConnection();

        var builder = new StringBuilder();
        builder.append("DELETE FROM ")
                .append(klass.getSimpleName())
                .append(" WHERE id = ?");

        try (var stmt = connection.prepareStatement(builder.toString())) {
            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException exception) {
            throw new RepositoryException(exception);
        }
    }

    private Map<String, String> getFieldValues(T obj) {
        Map<String, String> values = new HashMap<>();
        for (var field : fields) {
            field.setAccessible(true);

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

        return values;
    }
}
