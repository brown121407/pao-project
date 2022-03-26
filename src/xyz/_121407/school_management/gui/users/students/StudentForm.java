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
    public void fill(Student student) {
        super.fill(student);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public Student getValue() {
        var student = new Student();
        student.setFirstName(firstNameField.getText());
        student.setLastName(lastNameField.getText());
        student.setNationalId(nationalIdField.getText());
        student.setDateOfBirth(dateOfBirthPicker.getDate());
        student.setAddress(addressPicker.getValue());

        if (selectedId != null) {
            student.setId(selectedId);
        }

        return student;
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
