package xyz._121407.schoolmanagement.gui.users.students;

import xyz._121407.schoolmanagement.entities.Class;
import xyz._121407.schoolmanagement.entities.Student;
import xyz._121407.schoolmanagement.gui.users.UserForm;
import xyz._121407.schoolmanagement.repositories.IRepository;
import xyz._121407.schoolmanagement.services.InMemoryStore;
import xyz._121407.schoolmanagement.utils.EnglishFormatter;

import javax.swing.*;

public class StudentForm extends UserForm<Student> {
    JComboBox<Class> classComboBox = new JComboBox<>();
    DefaultComboBoxModel<Class> comboBoxModel = new DefaultComboBoxModel<>();

    public StudentForm() {
        super();

        comboBoxModel.addAll(InMemoryStore.getInstance().getClassRepository().getAll());
        classComboBox.setModel(comboBoxModel);

        var comboBoxPanel = makeFieldPanel("Class:");
        comboBoxPanel.add(classComboBox);

        add(comboBoxPanel);
        add(actionsPanel);
    }

    @Override
    public void fill(Student student) {
        super.fill(student);

        classComboBox.setSelectedItem(student.getKlass());
    }

    @Override
    public void clear() {
        super.clear();

        if (classComboBox.getModel().getSize() > 0) {
            classComboBox.setSelectedIndex(0);
        }
    }

    @Override
    public Student getValue() {
        var student = new Student();
        student.setFirstName(firstNameField.getText());
        student.setLastName(lastNameField.getText());
        student.setNationalId(nationalIdField.getText());
        student.setDateOfBirth(dateOfBirthPicker.getDate());
        student.setAddress(addressPicker.getValue());
        student.setKlass((Class) classComboBox.getSelectedItem());

        if (selectedId != null) {
            student.setId(selectedId);
        }

        return student;
    }

    @Override
    protected String getEntityName() {
        return EnglishFormatter.toHumanReadable(Student.class);
    }

    @Override
    protected IRepository<Student> getRepository() {
        return InMemoryStore.getInstance().getStudentRepository();
    }

    @Override
    public void refresh() {
        super.refresh();

        comboBoxModel.removeAllElements();

        var newList = InMemoryStore.getInstance().getClassRepository().getAll();
        comboBoxModel.addAll(newList);

        if (selectedId != null) {
            var selected = newList.stream().filter(x -> x.getId() == selectedId).findFirst();
            if (selected.isPresent()) {
                classComboBox.setSelectedItem(selected.get());
            } else if (newList.size() > 0) {
                classComboBox.setSelectedIndex(0);
            }
        }
    }
}
