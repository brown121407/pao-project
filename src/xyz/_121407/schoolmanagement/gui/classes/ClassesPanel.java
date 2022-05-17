package xyz._121407.schoolmanagement.gui.classes;

import xyz._121407.schoolmanagement.entities.Class;
import xyz._121407.schoolmanagement.gui.EntityManagerPanel;
import xyz._121407.schoolmanagement.services.Store;


public class ClassesPanel extends EntityManagerPanel<Class> {
    public ClassesPanel() {
        super(Class.class, new ClassForm());

        configureUI();
        configureFormEvents();
    }
}
