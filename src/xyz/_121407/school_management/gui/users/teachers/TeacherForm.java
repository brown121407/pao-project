package xyz._121407.school_management.gui.users.teachers;

import xyz._121407.school_management.entities.Teacher;
import xyz._121407.school_management.gui.FormPanel;
import xyz._121407.school_management.repositories.IRepository;
import xyz._121407.school_management.services.InMemoryStore;
import xyz._121407.school_management.utils.English;

public class TeacherForm extends FormPanel<Teacher> {
    public TeacherForm() {
        super();
    }

    @Override
    public void fill(Teacher obj) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Teacher getValue() {
        return null;
    }

    @Override
    protected String getEntityName() {
        return English.toHumanReadable(Teacher.class);
    }

    @Override
    protected IRepository<Teacher> getRepository() {
        return InMemoryStore.getInstance().getTeacherRepository();
    }
}
