package xyz._121407.school_management.entities;

public class Class {
    private int grade;
    private char letter;
    private Profile profile;
    private Room room;

    public Class(int grade, char letter, Profile profile, Room room) {
        this.grade = grade;
        this.letter = Character.toUpperCase(letter);
        this.profile = profile;
        this.room = room;
    }

    @Override
    public String toString() {
        return Integer.toString(grade) + Character.toUpperCase(letter);
    }
}
