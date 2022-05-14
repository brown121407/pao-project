package xyz._121407.schoolmanagement.gui.users.parents;

import xyz._121407.schoolmanagement.entities.Parent;
import xyz._121407.schoolmanagement.gui.users.UserForm;
import xyz._121407.schoolmanagement.repositories.IRepository;
import xyz._121407.schoolmanagement.services.Store;
import xyz._121407.schoolmanagement.utils.EnglishFormatter;

public class ParentForm extends UserForm<Parent> {
    public ParentForm() {
        super(Parent.class);

        add(actionsPanel);
    }

    @Override
    public void fill(Parent obj) {
        super.fill(obj);
    }

    @Override
    public void clear() {
        super.clear();
    }

    @Override
    public Parent getValue() {
        var parent = new Parent();
        parent.setFirstName(firstNameField.getText());
        parent.setLastName(lastNameField.getText());
        parent.setNationalId(nationalIdField.getText());
        parent.setDateOfBirth(dateOfBirthPicker.getDate());
        parent.setAddress(addressPicker.getValue());

        if (selectedId != null) {
            parent.setId(selectedId);
        }

        return parent;
    }
}
