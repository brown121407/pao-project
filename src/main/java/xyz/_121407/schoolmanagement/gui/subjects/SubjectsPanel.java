package xyz._121407.schoolmanagement.gui.subjects;

import xyz._121407.schoolmanagement.entities.Subject;
import xyz._121407.schoolmanagement.gui.EntityManagerPanel;
import xyz._121407.schoolmanagement.services.Store;


public class SubjectsPanel extends EntityManagerPanel<Subject> {
    public SubjectsPanel() {
        super(Subject.class, new SubjectForm());

        configureUI();
        configureFormEvents();
    }
}
