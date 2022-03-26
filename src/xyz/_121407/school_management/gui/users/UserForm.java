package xyz._121407.school_management.gui.users;

import com.github.lgooddatepicker.components.DatePicker;
import xyz._121407.school_management.entities.User;
import xyz._121407.school_management.gui.AddressPicker;
import xyz._121407.school_management.gui.FormPanel;

import javax.swing.*;

public abstract class UserForm<T extends User> extends FormPanel<T> {
    protected final JTextField firstNameField = new JTextField(DEFAULT_COLUMNS);
    protected final JTextField lastNameField = new JTextField(DEFAULT_COLUMNS);
    protected final JTextField nationalIdField = new JTextField(DEFAULT_COLUMNS);
    protected final DatePicker dateOfBirthPicker = new DatePicker();
    protected final AddressPicker addressPicker = new AddressPicker();

    public UserForm() {
        super();

        JPanel firstNamePanel = makeFieldPanel("First name:", firstNameField);

        JPanel lastNamePanel = makeFieldPanel("Last name:", lastNameField);

        JPanel nationalIdPanel = makeFieldPanel("National ID:", nationalIdField);

        JPanel dateOfBirthPanel = makeFieldPanel("Date of birth:");
        dateOfBirthPanel.add(dateOfBirthPicker);

        JPanel addressPanel = makeFieldPanel("Address:");
        addressPanel.add(addressPicker);

        add(firstNamePanel);
        add(lastNamePanel);
        add(nationalIdPanel);
        add(dateOfBirthPanel);
        add(addressPicker);
    }

    @Override
    public void fill(T obj) {
        super.fill(obj);

        firstNameField.setText(obj.getFirstName());
        lastNameField.setText(obj.getLastName());
        nationalIdField.setText(obj.getNationalId());
        dateOfBirthPicker.setDate(obj.getDateOfBirth());
        addressPicker.fill(obj.getAddress());
    }

    @Override
    public void clear() {
        super.clear();

        firstNameField.setText("");
        lastNameField.setText("");
        nationalIdField.setText("");
        dateOfBirthPicker.clear();
        addressPicker.clear();
    }
}
