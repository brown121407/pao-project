package xyz._121407.schoolmanagement.entities;

public class Profile implements Identifiable {
    private static int lastId = 0;

    private int id;
    private ProfileType type;
    private Subject intensive;

    public ProfileType getType() {
        return type;
    }

    public void setType(ProfileType type) {
        this.type = type;
    }

    private Subject getIntensive() {
        return intensive;
    }

    public void setIntensive(Subject intensive) {
        this.intensive = intensive;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int nextId() {
        return lastId++;
    }
}
