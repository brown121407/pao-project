package xyz._121407.schoolmanagement.entities;

import xyz._121407.schoolmanagement.annotations.CsvReadable;
import xyz._121407.schoolmanagement.annotations.CsvWritable;
import xyz._121407.schoolmanagement.utils.EnglishFormatter;

public class Room implements Identifiable {
    private static int lastId = 0;

    private int id;
    private RoomType roomType;
    private String name;
    private String building;
    private int floor;

    @CsvWritable(field = "type")
    public RoomType getRoomType() {
        return roomType;
    }

    @CsvReadable(field = "type")
    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @CsvWritable(field = "name")
    public String getName() {
        return name;
    }

    @CsvReadable(field = "name")
    public void setName(String name) {
        this.name = name;
    }

    @CsvWritable(field = "building")
    public String getBuilding() {
        return building;
    }

    @CsvReadable(field = "building")
    public void setBuilding(String building) {
        this.building = building;
    }

    @CsvWritable(field = "floor")
    public int getFloor() {
        return floor;
    }

    @CsvReadable(field = "floor")
    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return name + " (" + building + ", " + EnglishFormatter.toOrdinal(floor) + " floor)";
    }

    @Override
    @CsvWritable(field = "id")
    public int getId() {
        return id;
    }

    @Override
    @CsvReadable(field = "id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int nextId() {
        return lastId++;
    }
}
