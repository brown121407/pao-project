package xyz._121407.schoolmanagement.gui;

import xyz._121407.schoolmanagement.entities.Identifiable;
import xyz._121407.schoolmanagement.repositories.IRepository;

import javax.swing.*;
import java.util.function.Consumer;

public abstract class FormPanel<T extends Identifiable> extends JPanel implements Refreshable {
    protected static final int DEFAULT_COLUMNS = 15;

    protected JLabel statusLabel = new JLabel();

    protected JButton submitButton = new JButton();
    protected JButton deleteButton = new JButton();
    protected JPanel actionsPanel = new JPanel();

    protected Consumer<T> submitAction;
    protected Runnable deleteAction;

    protected Integer selectedId = null;

    protected FormPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        configureStatus();

        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        add(statusLabel);

        submitButton.setText("Submit");
        deleteButton.setText("Delete");
        deleteButton.setVisible(false);
        actionsPanel.add(submitButton);
        actionsPanel.add(deleteButton);

        submitButton.addActionListener(e -> {
            defaultSubmitAction();
        });

        deleteButton.addActionListener(e -> {
            defaultDeleteAction();
        });
    }

    public void fill(T obj) {
        selectedId = obj.getId();
        configureStatus(true, obj);
        deleteButton.setVisible(true);
    }

    public void clear() {
        selectedId = null;
        configureStatus();
        deleteButton.setVisible(false);
    }

    public abstract T getValue();

    public void onSubmit(Consumer<T> submitAction) {
        this.submitAction = submitAction;
    }

    public void onDelete(Runnable deleteAction) {
        this.deleteAction = deleteAction;
    }

    protected abstract String getEntityName();
    protected abstract IRepository<T> getRepository();

    protected void configureStatus() {
        configureStatus(false, null);
    }

    protected void configureStatus(boolean editing, T obj) {
        if (editing) {
            statusLabel.setText("Edit " + getEntityName() + ": " + obj);
        } else {
            statusLabel.setText("Create a new " + getEntityName());
        }
    }

    protected void defaultSubmitAction() {
        T obj = getValue();
        if (selectedId != null) {
            getRepository().update(obj);
        } else {
            getRepository().create(obj);
        }

        if (submitAction != null) {
            fill(obj);
            submitAction.accept(obj);
        }
    }

    protected void defaultDeleteAction() {
        if (selectedId != null) {
            getRepository().delete(selectedId);
            clear();

            if (deleteAction != null) {
                deleteAction.run();
            }
        }
    }

    protected JPanel makeFieldPanel(String labelText) {
        return makeFieldPanel(labelText, null);
    }

    protected JPanel makeFieldPanel(String labelText, JTextField textField) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel(labelText);
        panel.add(label);

        if (textField != null) {
            panel.add(textField);
        }

        return panel;
    }

    @Override
    public void refresh() { }
}
