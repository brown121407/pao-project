package xyz._121407.school_management.gui.users.students;

import xyz._121407.school_management.entities.Student;
import xyz._121407.school_management.gui.EntityManagerPanel;
import xyz._121407.school_management.services.InMemoryStore;


public class StudentsPanel extends EntityManagerPanel<Student> {
    public StudentsPanel() {
        repository = InMemoryStore.getInstance().getStudentRepository();
        formPanel = new StudentForm();

        configureUI();
        configureFormEvents();
    }
}
