package xyz._121407.school_management.gui.users.teachers;

import xyz._121407.school_management.entities.Subject;
import xyz._121407.school_management.entities.Teacher;
import xyz._121407.school_management.gui.users.UserForm;
import xyz._121407.school_management.repositories.IRepository;
import xyz._121407.school_management.services.InMemoryStore;
import xyz._121407.school_management.utils.English;

import javax.swing.*;

public class TeacherForm extends UserForm<Teacher> {
    JComboBox<Subject> subjectComboBox = new JComboBox<>();
    DefaultComboBoxModel<Subject> comboBoxModel = new DefaultComboBoxModel<>();

    public TeacherForm() {
        super();

        var comboBoxPanel = makeFieldPanel("Teaches:");
        comboBoxModel.addAll(InMemoryStore.getInstance().getSubjectRepository().getAll());
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
    protected String getEntityName() {
        return English.toHumanReadable(Teacher.class);
    }

    @Override
    protected IRepository<Teacher> getRepository() {
        return InMemoryStore.getInstance().getTeacherRepository();
    }

    @Override
    public void refresh() {
        super.refresh();

        comboBoxModel.removeAllElements();

        var newList = InMemoryStore.getInstance().getSubjectRepository().getAll();
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
