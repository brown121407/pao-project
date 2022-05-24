package xyz._121407.schoolmanagement.gui.users.students;

import xyz._121407.schoolmanagement.entities.Class;
import xyz._121407.schoolmanagement.entities.Parent;
import xyz._121407.schoolmanagement.entities.Student;
import xyz._121407.schoolmanagement.gui.users.UserForm;
import xyz._121407.schoolmanagement.services.Store;

import javax.swing.*;

public class StudentForm extends UserForm<Student> {
    JComboBox<Class> classComboBox = new JComboBox<>();
    DefaultComboBoxModel<Class> classComboBoxModel = new DefaultComboBoxModel<>();
    JComboBox<Parent> parentComboBox = new JComboBox<>();
    DefaultComboBoxModel<Parent> parentComboBoxModel = new DefaultComboBoxModel<>();

    public StudentForm() {
        super(Student.class);

        classComboBoxModel.addAll(Store.getInstance().get(Class.class).getAll());
        classComboBox.setModel(classComboBoxModel);

        var classComboBoxPanel = makeFieldPanel("Class:");
        classComboBoxPanel.add(classComboBox);

        parentComboBoxModel.addAll(Store.getInstance().get(Parent.class).getAll());
        parentComboBox.setModel(parentComboBoxModel);

        var parentComboBoxPanel = makeFieldPanel("Parent:");
        parentComboBoxPanel.add(parentComboBox);

        add(classComboBoxPanel);
        add(parentComboBoxPanel);
        add(actionsPanel);
    }

    @Override
    public void fill(Student student) {
        super.fill(student);

        refresh();
    }

    @Override
    public void clear() {
        super.clear();

        if (classComboBox.getModel().getSize() > 0) {
            classComboBox.setSelectedIndex(0);
        }

        if (parentComboBox.getModel().getSize() > 0) {
            parentComboBox.setSelectedIndex(0);
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
        student.setParent((Parent) parentComboBox.getSelectedItem());

        if (selectedId != null) {
            student.setId(selectedId);
        }

        return student;
    }

    @Override
    public void refresh() {
        super.refresh();

        var newClasses = Store.getInstance().get(Class.class).getAll();
        classComboBoxModel.removeAllElements();
        classComboBoxModel.addAll(newClasses);

        var newParents = Store.getInstance().get(Parent.class).getAll();
        parentComboBoxModel.removeAllElements();
        parentComboBoxModel.addAll(newParents);

        if (selectedId != null) {
            var selected = repository.findFirst(x -> x.getId() == selectedId);

            var selectedClass = newClasses.stream().filter(x -> x.getId() == selected.getClassId()).findFirst();
            if (selectedClass.isPresent()) {
                classComboBox.setSelectedItem(selectedClass.get());
            } else if (newClasses.size() > 0) {
                classComboBox.setSelectedIndex(0);
            }

            var selectedParent = newParents.stream().filter(x -> x.getId() == selected.getParentId()).findFirst();
            if (selectedParent.isPresent()) {
                parentComboBox.setSelectedItem(selectedParent.get());
            } else if (newClasses.size() > 0) {
                parentComboBox.setSelectedIndex(0);
            }
        }
    }
}
