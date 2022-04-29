package xyz._121407.schoolmanagement;

import xyz._121407.schoolmanagement.entities.*;
import xyz._121407.schoolmanagement.entities.Class;
import xyz._121407.schoolmanagement.gui.MainWindow;
import xyz._121407.schoolmanagement.services.EntityLoader;
import xyz._121407.schoolmanagement.services.SerializationConfig;
import xyz._121407.schoolmanagement.services.Store;

import javax.swing.*;
import java.io.IOException;

public class Main {
    private static final SerializationConfig serializationConfig = SerializationConfig.getInstance();
    private static final EntityLoader entityLoader = EntityLoader.getInstance();

    public static void main(String[] args) throws IOException {
        configure();

        SwingUtilities.invokeLater(MainWindow::new);
    }

    private static void configure() throws IOException {
        serializationConfig.setDelimiter(";");
        serializationConfig.setPath(Subject.class, "subjects.csv");
        serializationConfig.setPath(Profile.class, "profiles.csv");
        serializationConfig.setPath(Room.class, "rooms.csv");
        serializationConfig.setPath(Class.class, "classes.csv");
        serializationConfig.setPath(Student.class, "students.csv");
        serializationConfig.setPath(Teacher.class, "teachers.csv");
        serializationConfig.setPath(Parent.class, "parents.csv");

        // TODO handle IOException
        entityLoader.load();
    }
}
