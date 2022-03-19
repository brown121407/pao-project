package xyz._121407.school_management.gui.users.parents;

import xyz._121407.school_management.entities.Parent;
import xyz._121407.school_management.gui.FormPanel;
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
    }

    @Override
    public void clear() {

    }

    @Override
    public Parent getValue() {
        return null;
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
