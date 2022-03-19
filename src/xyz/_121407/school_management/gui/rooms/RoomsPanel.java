package xyz._121407.school_management.gui.rooms;

import xyz._121407.school_management.entities.Room;
import xyz._121407.school_management.gui.EntityManagerPanel;
import xyz._121407.school_management.services.InMemoryStore;

public class RoomsPanel extends EntityManagerPanel<Room> {
    public RoomsPanel() {
        formPanel = new RoomForm();
        repository = InMemoryStore.getInstance().getRoomRepository();

        configureUI();
        configureFormEvents();
    }
}
