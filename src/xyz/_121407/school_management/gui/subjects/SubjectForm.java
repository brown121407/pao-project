package xyz._121407.school_management.gui.subjects;

import xyz._121407.school_management.entities.Subject;
import xyz._121407.school_management.gui.FormPanel;
import xyz._121407.school_management.utils.English;

public class SubjectForm extends FormPanel<Subject> {
    public SubjectForm() {
        super();
    }

    @Override
    public void fill(Subject obj) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Subject getValue() {
        return null;
    }

    @Override
    protected String getEntityName() {
        return English.toHumanReadable(Subject.class);
    }
}
