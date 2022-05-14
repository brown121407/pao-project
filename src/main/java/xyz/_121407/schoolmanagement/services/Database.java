package xyz._121407.schoolmanagement.services;

import xyz._121407.schoolmanagement.annotations.Field;
import xyz._121407.schoolmanagement.annotations.FieldWriter;
import xyz._121407.schoolmanagement.annotations.References;
import xyz._121407.schoolmanagement.annotations.Table;
import xyz._121407.schoolmanagement.entities.Identifiable;
import xyz._121407.schoolmanagement.entities.Profile;
import xyz._121407.schoolmanagement.entities.Room;
import xyz._121407.schoolmanagement.entities.Subject;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Database {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/PAO";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    private static Connection connection;

    private Database() {}

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
            }
        } catch (SQLException exception) {
            System.err.println("Failed to connect to the database.");
            exception.printStackTrace();
            System.exit(1);
        }

        return connection;
    }

    public static void scaffold() {
        var connection = getConnection();
        scaffold(Subject.class, connection);
        scaffold(Profile.class, connection);
        scaffold(Room.class, connection);
        scaffold(xyz._121407.schoolmanagement.entities.Class.class, connection);
    }

    public static <T extends Identifiable> void scaffold(Class<T> klass, Connection connection) {
        if (!klass.isAnnotationPresent(Table.class)) {
            return;
        }

        List<String> fieldDecls = new ArrayList<>();
        List<String> constraints = new ArrayList<>();
        for (var field : klass.getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Field.class)) {
                var builder = new StringBuilder();
                builder.append(field.getName());

                if (field.getType().equals(int.class) || field.getType().equals(Integer.class)) {
                    builder.append(" INTEGER ");
                } else if (field.getType().equals(String.class) || field.getType().isEnum()) {
                    builder.append(" TEXT ");
                } else {
                    throw new RuntimeException("Not implemented");
                }

                var fieldProps = field.getAnnotation(Field.class);
                if (fieldProps.primaryKey()) {
                    builder.append(" AUTO_INCREMENT NOT NULL ");
                    constraints.add(" PRIMARY KEY (" + field.getName() + ")");
                } else if (!fieldProps.nullable()) {
                    builder.append(" NOT NULL ");
                }

                if (field.isAnnotationPresent(References.class)) {
                    var foreignKeyProps = field.getAnnotation(References.class);
                    constraints.add("FOREIGN KEY (" + field.getName() + ") REFERENCES "
                            + foreignKeyProps.table().getSimpleName() + "(" + foreignKeyProps.field()
                            + ")");
                }

                fieldDecls.add(builder.toString());
            }
        }

        var fieldsSql = String.join(", ", fieldDecls);
        var constraintsSql = String.join(", ", constraints);
        var tableContentSql = String.join(", ", fieldsSql, constraintsSql);
        var tableSql = "CREATE TABLE IF NOT EXISTS " + klass.getSimpleName()
                + "(" + tableContentSql + ")";

        try (var statement = connection.createStatement()) {
            statement.execute(tableSql);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
