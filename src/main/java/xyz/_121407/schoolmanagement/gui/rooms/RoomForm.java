package xyz._121407.schoolmanagement.gui.rooms;

import xyz._121407.schoolmanagement.entities.Room;
import xyz._121407.schoolmanagement.entities.RoomType;
import xyz._121407.schoolmanagement.gui.FormPanel;
import xyz._121407.schoolmanagement.repositories.IRepository;
import xyz._121407.schoolmanagement.services.Store;
import xyz._121407.schoolmanagement.utils.EnglishFormatter;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class RoomForm extends FormPanel<Room> {
    private JPanel typePanel = new JPanel();
    private Map<RoomType, JRadioButton> typeButtons = new HashMap<>();

    private JPanel namePanel = new JPanel();
    private JLabel nameLabel = new JLabel();
    private JTextField nameField = new JTextField();

    private JPanel buildingPanel = new JPanel();
    private JLabel buildingLabel = new JLabel();
    private JTextField buildingField = new JTextField();

    private JPanel floorPanel = new JPanel();
    private JLabel floorLabel = new JLabel();
    private JSpinner floorSpinner = new JSpinner();

    public RoomForm() {
        super(Room.class);

        typePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        ButtonGroup buttonGroup = new ButtonGroup();

        for (RoomType roomType : RoomType.values()) {
            JRadioButton radioButton = new JRadioButton(roomType.name());
            if (roomType == RoomType.CLASSROOM) {
                radioButton.setSelected(true);
            }

            buttonGroup.add(radioButton);
            typePanel.add(radioButton);
            typeButtons.put(roomType, radioButton);
        }

        add(typePanel);

        nameLabel.setText("Name:");
        nameField.setColumns(DEFAULT_COLUMNS);
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        buildingLabel.setText("Building:");
        buildingField.setColumns(DEFAULT_COLUMNS);
        buildingPanel.add(buildingLabel);
        buildingPanel.add(buildingField);

        floorLabel.setText("Floor:");
        SpinnerModel model = new SpinnerNumberModel(0, 0, 99, 1);
        floorSpinner.setModel(model);
        floorPanel.add(floorLabel);
        floorPanel.add(floorSpinner);

        add(namePanel);
        add(buildingPanel);
        add(floorPanel);
        add(actionsPanel);
    }

    @Override
    public void fill(Room room) {
        typeButtons.get(room.getRoomType()).setSelected(true);

        nameField.setText(room.getName());
        buildingField.setText(room.getBuilding());
        floorSpinner.setValue(room.getFloor());

        super.fill(room);
    }

    @Override
    public void clear() {
        typeButtons.get(RoomType.CLASSROOM).setSelected(true);
        nameField.setText("");
        buildingField.setText("");
        floorSpinner.setValue(0);

        super.clear();
    }

    @Override
    public Room getValue() {
        Room room = new Room();
        room.setRoomType(typeButtons.entrySet().stream().filter(x -> x.getValue().isSelected()).findFirst().get().getKey());
        room.setName(nameField.getText());
        room.setBuilding(buildingField.getText());
        room.setFloor((Integer) floorSpinner.getValue());

        if (selectedId != null) {
            room.setId(selectedId);
        }

        return room;
    }
}
