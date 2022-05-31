package xyz._121407.schoolmanagement.gui.users.parents;

import xyz._121407.schoolmanagement.entities.Parent;
import xyz._121407.schoolmanagement.gui.EntityManagerPanel;
import xyz._121407.schoolmanagement.services.Store;

public class ParentsPanel extends EntityManagerPanel<Parent> {
    public ParentsPanel() {
        super(Parent.class, new ParentForm());

        configureUI();
        configureFormEvents();
    }
}
