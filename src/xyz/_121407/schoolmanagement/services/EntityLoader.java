package xyz._121407.schoolmanagement.services;

import xyz._121407.schoolmanagement.entities.Class;
import xyz._121407.schoolmanagement.entities.Profile;
import xyz._121407.schoolmanagement.entities.Room;
import xyz._121407.schoolmanagement.entities.Subject;

import java.io.IOException;

public class EntityLoader {
    private static EntityLoader instance;

    private final Store store = Store.getInstance();
    private final EntityReader reader = EntityReader.getInstance();

    private EntityLoader() {}

    public static EntityLoader getInstance() {
        if (instance == null) {
            instance = new EntityLoader();
        }

        return instance;
    }

    public void load() throws IOException {
        var subjects = reader.read(Subject.class);
        var profiles = reader.read(Profile.class);
        var rooms = reader.read(Room.class);

        store.get(Subject.class).seed(subjects);
        store.get(Profile.class).seed(profiles);
        store.get(Room.class).seed(rooms);

        var classes = reader.read(Class.class);

        for (var klass : classes) {
            var profile = store.get(Profile.class).findFirst(x -> x.getId() == klass.getProfileId());
            var room = store.get(Room.class).findFirst(x -> x.getId() == klass.getRoomId());

            klass.setProfile(profile);
            klass.setRoom(room);
        }

        store.get(Class.class).seed(classes);
    }
}
