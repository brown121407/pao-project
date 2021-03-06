package xyz._121407.schoolmanagement.gui;

import xyz._121407.schoolmanagement.gui.classes.ClassesPanel;
import xyz._121407.schoolmanagement.gui.profiles.ProfilesPanel;
import xyz._121407.schoolmanagement.gui.rooms.RoomsPanel;
import xyz._121407.schoolmanagement.gui.subjects.SubjectsPanel;
import xyz._121407.schoolmanagement.gui.users.UsersPane;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    private static final String WINDOW_TITLE = "High School Management";
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 500;

    private final JFrame frame;

    public MainWindow() {
        frame = new JFrame();
        frame.setTitle(WINDOW_TITLE);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 5));

        var tabbedPane = new JTabbedPane();
        tabbedPane.add("Users", new UsersPane());
        tabbedPane.add("Rooms", new RoomsPanel());
        tabbedPane.add("Classes", new ClassesPanel());
        tabbedPane.add("Subjects", new SubjectsPanel());
        tabbedPane.add("Profiles", new ProfilesPanel());
        tabbedPane.getModel().addChangeListener(e -> {
            Refreshable comp = (Refreshable) tabbedPane.getSelectedComponent();
            comp.refresh();
        });

        frame.add(tabbedPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
