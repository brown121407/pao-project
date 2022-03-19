package xyz._121407.school_management.gui.users;

import com.github.lgooddatepicker.components.DatePicker;
import xyz._121407.school_management.entities.User;
import xyz._121407.school_management.gui.FormPanel;

import javax.swing.*;

public abstract class UserForm<T extends User> extends FormPanel<T> {
    protected final JTextField firstNameField = new JTextField();
    protected final JTextField lastNameField = new JTextField();
    protected final JTextField nationalIdField = new JTextField();
    protected final DatePicker dateOfBirthPicker = new DatePicker();

    public UserForm() {
        JPanel dateOfBirthPanel = new JPanel();
        JLabel dateOfBirthLabel = new JLabel("Date of birth: ");
        dateOfBirthPanel.add(dateOfBirthLabel);
        dateOfBirthPanel.add(dateOfBirthPicker);

        add(dateOfBirthPanel);
    }
}
