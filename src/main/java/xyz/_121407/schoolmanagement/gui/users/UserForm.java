package xyz._121407.schoolmanagement.gui.users;

import com.github.lgooddatepicker.components.DatePicker;
import xyz._121407.schoolmanagement.entities.Address;
import xyz._121407.schoolmanagement.entities.User;
import xyz._121407.schoolmanagement.gui.AddressPicker;
import xyz._121407.schoolmanagement.gui.FormPanel;
import xyz._121407.schoolmanagement.services.Store;

import javax.swing.*;

public abstract class UserForm<T extends User> extends FormPanel<T> {
    protected final JTextField firstNameField = new JTextField(DEFAULT_COLUMNS);
    protected final JTextField lastNameField = new JTextField(DEFAULT_COLUMNS);
    protected final JTextField nationalIdField = new JTextField(DEFAULT_COLUMNS);
    protected final DatePicker dateOfBirthPicker = new DatePicker();
    protected final AddressPicker addressPicker = new AddressPicker();

    protected UserForm(Class<T> klass) {
        super(klass);

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

        for (var listener : submitButton.getActionListeners()) {
            submitButton.removeActionListener(listener);
        }

        for (var listener : deleteButton.getActionListeners()) {
            deleteButton.removeActionListener(listener);
        }

        submitButton.addActionListener(e -> {
            try {
                T obj = getValue();

                var address = obj.getAddress();

                if (selectedId != null) {
                    Store.getInstance().get(Address.class).update(address);
                    repository.update(obj);
                } else {
                    Store.getInstance().get(Address.class).create(address);
                    obj.setAddressId(address.getId());
                    repository.create(obj);
                }

                if (submitAction != null) {
                    fill(obj);
                    submitAction.accept(obj);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Failed to create object. Please check that you filled all the fields correctly.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        deleteButton.addActionListener(e -> {
            try {
                if (selectedId != null) {
                    var address = addressPicker.getValue();
                    repository.delete(selectedId);
                    Store.getInstance().get(Address.class).delete(address.getId());
                    clear();

                    if (deleteAction != null) {
                        deleteAction.run();
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Failed to delete object. Reason: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                throw ex;
            }
        });
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
