package xyz._121407.schoolmanagement.gui.users.teachers;

import xyz._121407.schoolmanagement.entities.Teacher;
import xyz._121407.schoolmanagement.gui.EntityManagerPanel;
import xyz._121407.schoolmanagement.services.InMemoryStore;

public class TeachersPanel extends EntityManagerPanel<Teacher> {
    public TeachersPanel() {
        repository = InMemoryStore.getInstance().getTeacherRepository();
        formPanel = new TeacherForm();

        configureUI();
        configureFormEvents();
    }
}
