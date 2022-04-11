package xyz._121407.schoolmanagement.entities;

import xyz._121407.schoolmanagement.utils.EnglishFormatter;

public class Room implements Identifiable {
    private static int lastId = 0;

    private int id;
    private RoomType roomType;
    private String name;
    private String building;
    private int floor;

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return name + " (" + building + ", " + EnglishFormatter.toOrdinal(floor) + " floor)";
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
