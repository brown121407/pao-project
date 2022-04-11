package xyz._121407.schoolmanagement.gui.subjects;

import xyz._121407.schoolmanagement.entities.Subject;
import xyz._121407.schoolmanagement.gui.EntityManagerPanel;
import xyz._121407.schoolmanagement.services.InMemoryStore;


public class SubjectsPanel extends EntityManagerPanel<Subject> {
    public SubjectsPanel() {
        repository = InMemoryStore.getInstance().getSubjectRepository();
        formPanel = new SubjectForm();

        configureUI();
        configureFormEvents();
    }
}
