package xyz._121407.schoolmanagement.gui.rooms;

import xyz._121407.schoolmanagement.entities.Room;
import xyz._121407.schoolmanagement.gui.EntityManagerPanel;
import xyz._121407.schoolmanagement.services.InMemoryStore;

public class RoomsPanel extends EntityManagerPanel<Room> {
    public RoomsPanel() {
        formPanel = new RoomForm();
        repository = InMemoryStore.getInstance().getRoomRepository();

        configureUI();
        configureFormEvents();
    }
}
