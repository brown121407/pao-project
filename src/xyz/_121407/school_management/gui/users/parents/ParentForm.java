package xyz._121407.school_management.gui.users.parents;

import xyz._121407.school_management.entities.Parent;
import xyz._121407.school_management.gui.users.UserForm;
import xyz._121407.school_management.repositories.IRepository;
import xyz._121407.school_management.services.InMemoryStore;
import xyz._121407.school_management.utils.English;

public class ParentForm extends UserForm<Parent> {
    public ParentForm() {
        super();

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

    @Override
    protected String getEntityName() {
        return English.toHumanReadable(Parent.class);
    }

    @Override
    protected IRepository<Parent> getRepository() {
        return InMemoryStore.getInstance().getParentRepository();
    }
}
