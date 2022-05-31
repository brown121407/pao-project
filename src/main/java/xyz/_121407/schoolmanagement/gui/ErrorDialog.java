package xyz._121407.schoolmanagement.gui;

import javax.swing.*;
import java.awt.*;

public class ErrorDialog {
    public static void show(String message) {
        var textArea = new JTextArea(message);
        var scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(480, 320));
        JOptionPane.showMessageDialog(null, scrollPane, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void show(Exception exception) {
        show("", exception);
    }

    public static void show(String intro, Exception exception) {
        var builder = new StringBuilder(intro);
        if (!intro.equals("")) {
            builder.append("\n\n");
        }
        builder.append(exception.getMessage());
        builder.append('\n');
        for (var info : exception.getStackTrace()) {
            builder.append("    at");
            builder.append(info.toString());
            builder.append('\n');
        }

        show(builder.toString());
    }
}
