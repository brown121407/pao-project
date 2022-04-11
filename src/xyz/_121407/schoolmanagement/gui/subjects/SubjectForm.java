package xyz._121407.schoolmanagement.gui.subjects;

import xyz._121407.schoolmanagement.entities.Subject;
import xyz._121407.schoolmanagement.gui.FormPanel;
import xyz._121407.schoolmanagement.repositories.IRepository;
import xyz._121407.schoolmanagement.services.InMemoryStore;
import xyz._121407.schoolmanagement.utils.English;

import javax.swing.*;

public class SubjectForm extends FormPanel<Subject> {
    private final JTextField nameField = new JTextField();

    public SubjectForm() {
        super();

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Name: ");
        nameField.setColumns(DEFAULT_COLUMNS);
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        add(namePanel);
        add(actionsPanel);
    }

    @Override
    public void fill(Subject subject) {
        nameField.setText(subject.getName());

        super.fill(subject);
    }

    @Override
    public void clear() {
        nameField.setText("");

        super.clear();
    }

    @Override
    public Subject getValue() {
        Subject subject = new Subject();
        subject.setName(nameField.getText());

        if (selectedId != null) {
            subject.setId(selectedId);
        }

        return subject;
    }

    @Override
    protected String getEntityName() {
        return English.toHumanReadable(Subject.class);
    }

    @Override
    protected IRepository<Subject> getRepository() {
        return InMemoryStore.getInstance().getSubjectRepository();
    }
}
