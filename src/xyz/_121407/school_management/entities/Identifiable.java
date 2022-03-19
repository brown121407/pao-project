package xyz._121407.school_management.entities;

import xyz._121407.school_management.utils.English;

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
