package xyz._121407.schoolmanagement.entities;

import xyz._121407.schoolmanagement.annotations.*;

@Table
public class Class implements Identifiable {
    @Field(primaryKey = true)
    private int id;

    @Field
    private int grade;

    @Field
    private String letter;

    @Field
    @References(table = Profile.class, field = "id")
    private int profileId;

    private Profile profile;

    @Field
    @References(table = Room.class, field = "id")
    private int roomId;

    private Room room;

    @FieldWriter(field = "grade")
    public int getGrade() {
        return grade;
    }

    @FieldReader(field = "grade")
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @FieldWriter(field = "letter")
    public String getLetter() {
        return letter;
    }

    @FieldReader(field = "letter")
    public void setLetter(String letter) {
        this.letter = letter;
    }

    @FieldWriter(field = "profileId")
    public int getProfileId() {
        return profileId;
    }

    @FieldReader(field = "profileId")
    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
        this.profileId = profile.getId();
    }

    @FieldWriter(field = "roomId")
    public int getRoomId() {
        return roomId;
    }

    @FieldReader(field = "roomId")
    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
        this.roomId = room.getId();
    }

    @Override
    public String toString() {
        return grade + letter.toUpperCase();
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
