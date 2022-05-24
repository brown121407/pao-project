package xyz._121407.schoolmanagement;

import xyz._121407.schoolmanagement.entities.*;
import xyz._121407.schoolmanagement.entities.Class;
import xyz._121407.schoolmanagement.exceptions.RepositoryException;
import xyz._121407.schoolmanagement.gui.MainWindow;
import xyz._121407.schoolmanagement.services.Database;
import xyz._121407.schoolmanagement.services.EntityLoader;
import xyz._121407.schoolmanagement.services.SerializationConfig;
import xyz._121407.schoolmanagement.services.Store;
import xyz._121407.schoolmanagement.services.logging.Log;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    private static final SerializationConfig serializationConfig = SerializationConfig.getInstance();

    public static void main(String[] args) {
        try {
            configure();

            SwingUtilities.invokeLater(MainWindow::new);

            Database.closeConnection();
        } catch (IOException e) {
            System.err.println("Failed to initialize application.");
            System.err.println(e.getMessage());
        } catch (RepositoryException e) {
            System.err.println("A repository failed to do its job. Sorry! Quitting...");
            System.err.println(Arrays.stream(e.getSuppressed()).map(Throwable::getMessage).collect(Collectors.toList()));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void configure() throws IOException {
        Database.scaffold();
    }
}
