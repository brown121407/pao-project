package xyz._121407.school_management.gui.users.students;

import xyz._121407.school_management.entities.Student;
import xyz._121407.school_management.gui.FormPanel;
import xyz._121407.school_management.utils.English;

public class StudentForm extends FormPanel<Student> {
    public StudentForm() {
        super();
    }

    @Override
    public void fill(Student obj) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Student getValue() {
        return null;
    }

    @Override
    protected String getEntityName() {
        return English.toHumanReadable(Student.class);
    }
}
