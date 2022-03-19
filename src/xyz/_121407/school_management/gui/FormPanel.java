package xyz._121407.school_management.gui;

import xyz._121407.school_management.entities.Identifiable;
import xyz._121407.school_management.entities.Room;

import javax.swing.*;
import java.util.function.Consumer;

public abstract class FormPanel<T extends Identifiable> extends JPanel {
    protected JLabel statusLabel = new JLabel();

    protected JButton submitButton = new JButton();
    protected JButton deleteButton = new JButton();
    protected JPanel actionsPanel = new JPanel();

    protected Consumer<Room> submitAction;
    protected Runnable deleteAction;

    protected FormPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        configureStatus();

        statusLabel.setHorizontalAlignment(JLabel.CENTER);
        statusLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        add(statusLabel);

        actionsPanel.add(submitButton);
        actionsPanel.add(deleteButton);
    }

    public abstract void fill(T obj);
    public abstract void clear();
    public abstract T getValue();

    public void onSubmit(Consumer<Room> submitAction) {
        this.submitAction = submitAction;
    }

    public void onDelete(Runnable deleteAction) {
        this.deleteAction = deleteAction;
    }

    protected abstract String getEntityName();

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
}
