package xyz._121407.school_management.entities;

import java.util.Date;

public class Grade extends Identifiable {
    private int score;
    private Date when;
    private Subject subject;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
