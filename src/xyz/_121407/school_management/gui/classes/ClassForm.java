package xyz._121407.school_management.gui.classes;

import xyz._121407.school_management.entities.Class;
import xyz._121407.school_management.gui.FormPanel;
import xyz._121407.school_management.repositories.IRepository;
import xyz._121407.school_management.services.InMemoryStore;
import xyz._121407.school_management.utils.English;

public class ClassForm extends FormPanel<Class> {
    public ClassForm() {
        super();
    }

    @Override
    public void fill(Class obj) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Class getValue() {
        return null;
    }

    @Override
    protected String getEntityName() {
        return English.toHumanReadable(Class.class);
    }

    @Override
    protected IRepository<Class> getRepository() {
        return InMemoryStore.getInstance().getClassRepository();
    }
}
