package xyz._121407.schoolmanagement.gui.rooms;

import xyz._121407.schoolmanagement.entities.Room;
import xyz._121407.schoolmanagement.gui.EntityManagerPanel;
import xyz._121407.schoolmanagement.services.Store;

public class RoomsPanel extends EntityManagerPanel<Room> {
    public RoomsPanel() {
        super(Room.class, new RoomForm());

        configureUI();
        configureFormEvents();
    }
}
