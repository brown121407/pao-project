package xyz._121407.school_management.entities;

public class Class extends Identifiable {
    private int grade;
    private char letter;
    private Profile profile;
    private Room room;

    private int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return Integer.toString(grade) + Character.toUpperCase(letter);
    }
}
