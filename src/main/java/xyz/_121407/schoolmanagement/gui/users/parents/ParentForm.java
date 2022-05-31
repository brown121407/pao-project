package xyz._121407.schoolmanagement.gui.users.parents;

import xyz._121407.schoolmanagement.entities.Parent;
import xyz._121407.schoolmanagement.gui.users.UserForm;

import javax.swing.*;

public class ParentForm extends UserForm<Parent> {
    private final JTextField phoneNumberField = new JTextField(DEFAULT_COLUMNS);

    public ParentForm() {
        super(Parent.class);

        var phoneNumberPanel = makeFieldPanel("Phone number:", phoneNumberField);

        add(phoneNumberPanel);
        add(actionsPanel);
    }

    @Override
    public void fill(Parent obj) {
        super.fill(obj);

        phoneNumberField.setText(obj.getPhoneNumber());
    }

    @Override
    public void clear() {
        super.clear();

        phoneNumberField.setText("");
    }

    @Override
    public Parent getValue() {
        var parent = new Parent();
        parent.setFirstName(firstNameField.getText());
        parent.setLastName(lastNameField.getText());
        parent.setNationalId(nationalIdField.getText());
        parent.setDateOfBirth(dateOfBirthPicker.getDate());
        parent.setAddress(addressPicker.getValue());
        parent.setPhoneNumber(phoneNumberField.getText());

        if (selectedId != null) {
            parent.setId(selectedId);
        }

        return parent;
    }
}
