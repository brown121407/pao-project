package xyz._121407.schoolmanagement.entities;

import xyz._121407.schoolmanagement.annotations.*;
import xyz._121407.schoolmanagement.utils.EnglishFormatter;

@Table
public class Room implements Identifiable {
    @Field(primaryKey = true)
    private int id;

    @Field
    private RoomType roomType;

    @Field
    private String name;

    @Field
    private String building;

    @Field
    private int floor;

    @FieldWriter(field = "type")
    public RoomType getRoomType() {
        return roomType;
    }

    @FieldReader(field = "type")
    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @FieldWriter(field = "name")
    public String getName() {
        return name;
    }

    @FieldReader(field = "name")
    public void setName(String name) {
        this.name = name;
    }

    @FieldWriter(field = "building")
    public String getBuilding() {
        return building;
    }

    @FieldReader(field = "building")
    public void setBuilding(String building) {
        this.building = building;
    }

    @FieldWriter(field = "floor")
    public int getFloor() {
        return floor;
    }

    @FieldReader(field = "floor")
    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return name + " (" + building + ", " + EnglishFormatter.toOrdinal(floor) + " floor)";
    }

    @Override
    @FieldWriter(field = "id")
    public int getId() {
        return id;
    }

    @Override
    @FieldReader(field = "id")
    public void setId(Integer id) {
        this.id = id;
    }
}
