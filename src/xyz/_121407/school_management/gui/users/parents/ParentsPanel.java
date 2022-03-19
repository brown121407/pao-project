package xyz._121407.school_management.gui.users.parents;

import xyz._121407.school_management.entities.Parent;
import xyz._121407.school_management.gui.EntityManagerPanel;
import xyz._121407.school_management.services.InMemoryStore;

public class ParentsPanel extends EntityManagerPanel<Parent> {
    public ParentsPanel() {
        repository = InMemoryStore.getInstance().getParentRepository();
        formPanel = new ParentForm();

        configureUI();
        configureFormEvents();
    }
}
