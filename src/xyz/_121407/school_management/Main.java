package xyz._121407.school_management;

import xyz._121407.school_management.gui.MainWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var window = new MainWindow();
        });
    }
}
