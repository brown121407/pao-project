package xyz._121407.schoolmanagement.gui.classes;

import xyz._121407.schoolmanagement.entities.Class;
import xyz._121407.schoolmanagement.entities.Profile;
import xyz._121407.schoolmanagement.entities.Room;
import xyz._121407.schoolmanagement.gui.FormPanel;
import xyz._121407.schoolmanagement.services.Store;

import javax.swing.*;

public class ClassForm extends FormPanel<Class> {
    JSpinner gradeSpinner = new JSpinner();
    JTextField letterField = new JTextField(DEFAULT_COLUMNS);
    JComboBox<Room> roomComboBox = new JComboBox<>();
    DefaultComboBoxModel<Room> roomComboBoxModel = new DefaultComboBoxModel<>();
    JComboBox<Profile> profileComboBox = new JComboBox<>();
    DefaultComboBoxModel<Profile> profileComboBoxModel = new DefaultComboBoxModel<>();

    public ClassForm() {
        super(Class.class);

        var gradePanel = makeFieldPanel("Grade:");
        SpinnerModel model = new SpinnerNumberModel(5, 5, 13, 1);
        gradeSpinner.setModel(model);
        gradePanel.add(gradeSpinner);

        var letterPanel = makeFieldPanel("Letter:", letterField);

        var roomPanel = makeFieldPanel("Room:");
        roomComboBoxModel.addAll(Store.getInstance().get(Room.class).getAll());
        roomComboBox.setModel(roomComboBoxModel);
        roomPanel.add(roomComboBox);

        var profilePanel = makeFieldPanel("Profile:");
        profileComboBoxModel.addAll(Store.getInstance().get(Profile.class).getAll());
        profileComboBox.setModel(profileComboBoxModel);
        profilePanel.add(profileComboBox);

        add(gradePanel);
        add(letterPanel);
        add(roomPanel);
        add(profilePanel);
        add(actionsPanel);
    }

    @Override
    public void fill(Class obj) {
        super.fill(obj);

        gradeSpinner.setValue(obj.getGrade());
        letterField.setText(obj.getLetter());
        refresh();
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
        klass.setProfile((Profile) profileComboBox.getSelectedItem());

        if (selectedId != null) {
            klass.setId(selectedId);
        }

        return klass;
    }

    @Override
    public void refresh() {
        super.refresh();

        roomComboBox.removeAllItems();

        var newRooms = Store.getInstance().get(Room.class).getAll();
        roomComboBoxModel.addAll(newRooms);

        profileComboBox.removeAllItems();

        var newProfiles = Store.getInstance().get(Profile.class).getAll();
        profileComboBoxModel.addAll(newProfiles);

        if (selectedId != null) {
            var selected = repository.findFirst(x -> x.getId() == selectedId);

            var selectedRoom = newRooms.stream().filter(x -> x.getId() == selected.getRoomId()).findFirst();
            if (selectedRoom.isPresent()) {
                roomComboBox.setSelectedItem(selectedRoom.get());
            } else if (newRooms.size() > 0) {
                roomComboBox.setSelectedIndex(0);
            }

            var selectedProfile = newProfiles.stream().filter(x -> x.getId() == selected.getProfileId()).findFirst();
            if (selectedProfile.isPresent()) {
                profileComboBox.setSelectedItem(selectedProfile.get());
            } else if (newProfiles.size() > 0) {
                profileComboBox.setSelectedIndex(0);
            }
        }
    }
}
