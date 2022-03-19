package xyz._121407.school_management.gui.users.teachers;

import xyz._121407.school_management.entities.Teacher;
import xyz._121407.school_management.gui.EntityManagerPanel;
import xyz._121407.school_management.services.InMemoryStore;

public class TeachersPanel extends EntityManagerPanel<Teacher> {
    public TeachersPanel() {
        repository = InMemoryStore.getInstance().getTeacherRepository();
        formPanel = new TeacherForm();

        configureUI();
        configureFormEvents();
    }
}
