package xyz._121407.school_management.gui.subjects;

import xyz._121407.school_management.entities.Subject;
import xyz._121407.school_management.gui.EntityManagerPanel;
import xyz._121407.school_management.services.InMemoryStore;


public class SubjectsPanel extends EntityManagerPanel<Subject> {
    public SubjectsPanel() {
        repository = InMemoryStore.getInstance().getSubjectRepository();
        formPanel = new SubjectForm();

        configureUI();
        configureFormEvents();
    }
}
