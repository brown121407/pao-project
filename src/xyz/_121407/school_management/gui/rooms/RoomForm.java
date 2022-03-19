package xyz._121407.school_management.gui.rooms;

import xyz._121407.school_management.entities.Room;
import xyz._121407.school_management.entities.RoomType;
import xyz._121407.school_management.gui.FormPanel;
import xyz._121407.school_management.services.InMemoryStore;
import xyz._121407.school_management.utils.English;

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

    private Integer roomId = null;

    public RoomForm() {
        super();

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
        nameField.setColumns(15);
        namePanel.add(nameLabel);
        namePanel.add(nameField);

        buildingLabel.setText("Building:");
        buildingField.setColumns(15);
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

        submitButton.addActionListener(e -> {
            Room room = getValue();
            if (roomId != null) {
                InMemoryStore.getInstance().getRoomRepository().update(room);
            } else {
                InMemoryStore.getInstance().getRoomRepository().create(room);
            }

            if (submitAction != null) {
                submitAction.accept(room);
                fill(room);
            }
        });
        submitButton.setText("Submit");

        deleteButton.setText("Delete");
        deleteButton.setVisible(false);
        deleteButton.addActionListener(e -> {
            if (roomId != null) {
                InMemoryStore.getInstance().getRoomRepository().delete(roomId);
                clear();

                if (deleteAction != null) {
                    deleteAction.run();
                }
            }
        });

        add(actionsPanel);
    }

    @Override
    public void fill(Room room) {
        typeButtons.get(room.getRoomType()).setSelected(true);

        nameField.setText(room.getName());
        buildingField.setText(room.getBuilding());
        floorSpinner.setValue(room.getFloor());

        roomId = room.getId();

        configureStatus(true, room);
        deleteButton.setVisible(true);
    }

    @Override
    public void clear() {
        typeButtons.get(RoomType.CLASSROOM).setSelected(true);
        nameField.setText("");
        buildingField.setText("");
        floorSpinner.setValue(0);

        roomId = null;

        configureStatus();
        deleteButton.setVisible(false);
    }

    @Override
    public Room getValue() {
        Room room = new Room();
        room.setRoomType(typeButtons.entrySet().stream().filter(x -> x.getValue().isSelected()).findFirst().get().getKey());
        room.setName(nameField.getText());
        room.setBuilding(buildingField.getText());
        room.setFloor((Integer) floorSpinner.getValue());

        if (roomId != null) {
            room.setId(roomId);
        }

        return room;
    }

    @Override
    protected String getEntityName() {
        return English.toHumanReadable(Room.class);
    }
}
