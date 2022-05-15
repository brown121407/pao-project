package xyz._121407.schoolmanagement.gui;

import xyz._121407.schoolmanagement.entities.Identifiable;
import xyz._121407.schoolmanagement.repositories.IRepository;
import xyz._121407.schoolmanagement.services.Store;
import xyz._121407.schoolmanagement.utils.EnglishFormatter;

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
    protected String entityName;
    protected IRepository<T> repository;

    protected FormPanel(Class<T> klass) {
        this.entityName = EnglishFormatter.toHumanReadable(klass);
        this.repository = Store.getInstance().get(klass);

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

        submitButton.addActionListener(e -> defaultSubmitAction());

        deleteButton.addActionListener(e -> defaultDeleteAction());
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

    protected void configureStatus() {
        configureStatus(false, null);
    }

    protected void configureStatus(boolean editing, T obj) {
        if (editing) {
            statusLabel.setText("Edit " + entityName + ": " + obj);
        } else {
            statusLabel.setText("Create a new " + entityName);
        }
    }

    protected void defaultSubmitAction() {
        try {
            T obj = getValue();
            if (selectedId != null) {
                repository.update(obj);
            } else {
                repository.create(obj);
            }

            if (submitAction != null) {
                fill(obj);
                submitAction.accept(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to create object. Please check that you filled all the fields correctly.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void defaultDeleteAction() {
        try {
            if (selectedId != null) {
                repository.delete(selectedId);
                clear();

                if (deleteAction != null) {
                    deleteAction.run();
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Failed to delete object. Reason: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
