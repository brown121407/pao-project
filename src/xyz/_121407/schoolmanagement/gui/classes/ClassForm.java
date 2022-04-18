package xyz._121407.schoolmanagement.gui.classes;

import xyz._121407.schoolmanagement.entities.Class;
import xyz._121407.schoolmanagement.entities.Room;
import xyz._121407.schoolmanagement.gui.FormPanel;
import xyz._121407.schoolmanagement.repositories.IRepository;
import xyz._121407.schoolmanagement.services.InMemoryStore;
import xyz._121407.schoolmanagement.utils.EnglishFormatter;

import javax.swing.*;

public class ClassForm extends FormPanel<Class> {
    JSpinner gradeSpinner = new JSpinner();
    JTextField letterField = new JTextField(DEFAULT_COLUMNS);
    JComboBox<Room> roomComboBox = new JComboBox<>();
    DefaultComboBoxModel<Room> comboBoxModel = new DefaultComboBoxModel<>();

    public ClassForm() {
        super();

        var gradePanel = makeFieldPanel("Grade:");
        SpinnerModel model = new SpinnerNumberModel(5, 5, 13, 1);
        gradeSpinner.setModel(model);
        gradePanel.add(gradeSpinner);

        var letterPanel = makeFieldPanel("Letter:", letterField);

        var roomPanel = makeFieldPanel("Room:");
        comboBoxModel.addAll(InMemoryStore.getInstance().getRoomRepository().getAll());
        roomComboBox.setModel(comboBoxModel);
        roomPanel.add(roomComboBox);

        add(gradePanel);
        add(letterPanel);
        add(roomPanel);
        add(actionsPanel);
    }

    @Override
    public void fill(Class obj) {
        super.fill(obj);

        gradeSpinner.setValue(obj.getGrade());
        letterField.setText(obj.getLetter());
        roomComboBox.setSelectedItem(obj.getRoom());
    }

    @Override
    public void clear() {
        super.clear();

        gradeSpinner.setValue(5);
        letterField.setText("");
        if (roomComboBox.getModel().getSize() > 0) {
            roomComboBox.setSelectedIndex(0);
        }
    }

    @Override
    public Class getValue() {
        var klass = new Class();
        klass.setGrade((Integer) gradeSpinner.getValue());
        klass.setLetter(letterField.getText());
        klass.setRoom((Room) roomComboBox.getSelectedItem());

        if (selectedId != null) {
            klass.setId(selectedId);
        }

        return klass;
    }

    @Override
    protected String getEntityName() {
        return EnglishFormatter.toHumanReadable(Class.class);
    }

    @Override
    protected IRepository<Class> getRepository() {
        return InMemoryStore.getInstance().getClassRepository();
    }

    @Override
    public void refresh() {
        super.refresh();

        roomComboBox.removeAllItems();

        var newList = InMemoryStore.getInstance().getRoomRepository().getAll();
        comboBoxModel.addAll(newList);

        if (selectedId != null) {
            var selected = newList.stream().filter(x -> x.getId() == selectedId).findFirst();
            if (selected.isPresent()) {
                roomComboBox.setSelectedItem(selected.get());
            } else if (newList.size() > 0) {
                roomComboBox.setSelectedIndex(0);
            }
        }
    }
}
