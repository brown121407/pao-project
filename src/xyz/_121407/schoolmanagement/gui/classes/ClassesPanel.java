package xyz._121407.schoolmanagement.gui.classes;

import xyz._121407.schoolmanagement.entities.Class;
import xyz._121407.schoolmanagement.gui.EntityManagerPanel;
import xyz._121407.schoolmanagement.services.InMemoryStore;


public class ClassesPanel extends EntityManagerPanel<Class> {
    public ClassesPanel() {
        repository = InMemoryStore.getInstance().getClassRepository();
        formPanel = new ClassForm();

        configureUI();
        configureFormEvents();
    }
}
