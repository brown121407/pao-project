package xyz._121407.schoolmanagement.gui.users.students;

import xyz._121407.schoolmanagement.entities.Student;
import xyz._121407.schoolmanagement.gui.EntityManagerPanel;
import xyz._121407.schoolmanagement.services.Store;


public class StudentsPanel extends EntityManagerPanel<Student> {
    public StudentsPanel() {
        super(Student.class, new StudentForm());

        configureUI();
        configureFormEvents();
    }
}
