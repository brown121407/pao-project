package xyz._121407.schoolmanagement.entities;

import xyz._121407.schoolmanagement.annotations.CsvReadable;
import xyz._121407.schoolmanagement.annotations.CsvWritable;

public class Class implements Identifiable {
    private int id;
    private int grade;
    private String letter;
    private int profileId;
    private Profile profile;
    private int roomId;
    private Room room;

    @CsvWritable(field = "grade")
    public int getGrade() {
        return grade;
    }

    @CsvReadable(field = "grade")
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @CsvWritable(field = "letter")
    public String getLetter() {
        return letter;
    }

    @CsvReadable(field = "letter")
    public void setLetter(String letter) {
        this.letter = letter;
    }

    @CsvWritable(field = "profileId")
    public int getProfileId() {
        return profileId;
    }

    @CsvReadable(field = "profileId")
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

    @CsvWritable(field = "roomId")
    public int getRoomId() {
        return roomId;
    }

    @CsvReadable(field = "roomId")
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
    @CsvWritable(field = "id")
    public int getId() {
        return id;
    }

    @Override
    @CsvReadable(field = "id")
    public void setId(Integer id) {
        this.id = id;
    }
}
