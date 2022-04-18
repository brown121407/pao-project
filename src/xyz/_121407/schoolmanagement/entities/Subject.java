package xyz._121407.schoolmanagement.entities;

public class Subject implements Identifiable {
    private static int lastId = 0;

    private int id = 0;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
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
