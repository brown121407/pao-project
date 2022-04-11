package xyz._121407.schoolmanagement.entities;

public abstract class Identifiable {
    private static int lastId = 1;

    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int nextId() {
        return lastId++;
    }
}
