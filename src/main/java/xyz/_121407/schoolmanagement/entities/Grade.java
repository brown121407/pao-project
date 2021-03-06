package xyz._121407.schoolmanagement.entities;

import java.util.Date;

public class Grade implements Identifiable {
    private int id;
    private int score;
    private Date when;
    private Subject subject;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
