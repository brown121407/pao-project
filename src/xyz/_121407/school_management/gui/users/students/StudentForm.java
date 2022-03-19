package xyz._121407.school_management.gui.users.students;

import xyz._121407.school_management.entities.Student;
import xyz._121407.school_management.gui.users.UserForm;
import xyz._121407.school_management.repositories.IRepository;
import xyz._121407.school_management.services.InMemoryStore;
import xyz._121407.school_management.utils.English;

public class StudentForm extends UserForm<Student> {
    public StudentForm() {
        super();

        add(actionsPanel);
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

    @Override
    protected IRepository<Student> getRepository() {
        return InMemoryStore.getInstance().getStudentRepository();
    }
}
