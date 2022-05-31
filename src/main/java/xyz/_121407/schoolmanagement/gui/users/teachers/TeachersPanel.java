package xyz._121407.schoolmanagement.gui.users.teachers;

import xyz._121407.schoolmanagement.entities.Teacher;
import xyz._121407.schoolmanagement.gui.EntityManagerPanel;
import xyz._121407.schoolmanagement.services.Store;

public class TeachersPanel extends EntityManagerPanel<Teacher> {
    public TeachersPanel() {
        super(Teacher.class, new TeacherForm());

        configureUI();
        configureFormEvents();
    }
}
