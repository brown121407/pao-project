package xyz._121407.school_management.gui.classes;

import xyz._121407.school_management.entities.Class;
import xyz._121407.school_management.gui.EntityManagerPanel;
import xyz._121407.school_management.services.InMemoryStore;


public class ClassesPanel extends EntityManagerPanel<Class> {
    public ClassesPanel() {
        repository = InMemoryStore.getInstance().getClassRepository();
        formPanel = new ClassForm();

        configureUI();
        configureFormEvents();
    }
}
