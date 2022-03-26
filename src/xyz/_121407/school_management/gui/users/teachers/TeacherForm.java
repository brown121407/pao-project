package xyz._121407.school_management.gui.users.teachers;

import xyz._121407.school_management.entities.Teacher;
import xyz._121407.school_management.gui.users.UserForm;
import xyz._121407.school_management.repositories.IRepository;
import xyz._121407.school_management.services.InMemoryStore;
import xyz._121407.school_management.utils.English;

public class TeacherForm extends UserForm<Teacher> {
    public TeacherForm() {
        super();

        add(actionsPanel);
    }

    @Override
    public void fill(Teacher obj) {
        super.fill(obj);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public Teacher getValue() {
        var teacher = new Teacher();
        teacher.setFirstName(firstNameField.getText());
        teacher.setLastName(lastNameField.getText());
        teacher.setNationalId(nationalIdField.getText());
        teacher.setDateOfBirth(dateOfBirthPicker.getDate());
        teacher.setAddress(addressPicker.getValue());

        if (selectedId != null) {
            teacher.setId(selectedId);
        }

        return teacher;
    }

    @Override
    protected String getEntityName() {
        return English.toHumanReadable(Teacher.class);
    }

    @Override
    protected IRepository<Teacher> getRepository() {
        return InMemoryStore.getInstance().getTeacherRepository();
    }
}
