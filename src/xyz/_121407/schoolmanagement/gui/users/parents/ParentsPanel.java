package xyz._121407.schoolmanagement.gui.users.parents;

import xyz._121407.schoolmanagement.entities.Parent;
import xyz._121407.schoolmanagement.gui.EntityManagerPanel;
import xyz._121407.schoolmanagement.services.InMemoryStore;

public class ParentsPanel extends EntityManagerPanel<Parent> {
    public ParentsPanel() {
        repository = InMemoryStore.getInstance().getParentRepository();
        formPanel = new ParentForm();

        configureUI();
        configureFormEvents();
    }
}
