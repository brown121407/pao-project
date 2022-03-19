package xyz._121407.school_management.gui.users;

import xyz._121407.school_management.gui.users.parents.ParentsPanel;
import xyz._121407.school_management.gui.users.students.StudentsPanel;
import xyz._121407.school_management.gui.users.teachers.TeachersPanel;

import javax.swing.*;

public class UsersPane extends JTabbedPane {
    public UsersPane() {
        add("Students", new StudentsPanel());
        add("Teachers", new TeachersPanel());
        add("Parents", new ParentsPanel());
    }
}
