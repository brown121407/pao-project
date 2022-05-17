package xyz._121407.schoolmanagement.gui.users.teachers;

import xyz._121407.schoolmanagement.entities.Subject;
import xyz._121407.schoolmanagement.entities.Teacher;
import xyz._121407.schoolmanagement.gui.users.UserForm;
import xyz._121407.schoolmanagement.repositories.IRepository;
import xyz._121407.schoolmanagement.services.Store;
import xyz._121407.schoolmanagement.utils.EnglishFormatter;

import javax.swing.*;

public class TeacherForm extends UserForm<Teacher> {
    JComboBox<Subject> subjectComboBox = new JComboBox<>();
    DefaultComboBoxModel<Subject> comboBoxModel = new DefaultComboBoxModel<>();

    public TeacherForm() {
        super(Teacher.class);

        var comboBoxPanel = makeFieldPanel("Teaches:");
        comboBoxModel.addAll(Store.getInstance().get(Subject.class).getAll());
        subjectComboBox.setModel(comboBoxModel);
        comboBoxPanel.add(subjectComboBox);

        add(comboBoxPanel);
        add(actionsPanel);
    }

    @Override
    public void fill(Teacher obj) {
        super.fill(obj);

        subjectComboBox.setSelectedItem(obj.getSubject());
    }

    @Override
    public void clear() {
        super.clear();

        if (subjectComboBox.getModel().getSize() > 0) {
            subjectComboBox.setSelectedIndex(0);
        }
    }

    @Override
    public Teacher getValue() {
        var teacher = new Teacher();
        teacher.setFirstName(firstNameField.getText());
        teacher.setLastName(lastNameField.getText());
        teacher.setNationalId(nationalIdField.getText());
        teacher.setDateOfBirth(dateOfBirthPicker.getDate());
        teacher.setAddress(addressPicker.getValue());
        teacher.setSubject((Subject) subjectComboBox.getSelectedItem());

        if (selectedId != null) {
            teacher.setId(selectedId);
        }

        return teacher;
    }

    @Override
    public void refresh() {
        super.refresh();

        comboBoxModel.removeAllElements();

        var newList = Store.getInstance().get(Subject.class).getAll();
        comboBoxModel.addAll(newList);

        if (selectedId != null) {
            var selected = newList.stream().filter(x -> x.getId() == selectedId).findFirst();
            if (selected.isPresent()) {
                subjectComboBox.setSelectedItem(selected.get());
            } else if (newList.size() > 0) {
                subjectComboBox.setSelectedIndex(0);
            }
        }
    }
}
