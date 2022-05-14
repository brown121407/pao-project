package xyz._121407.schoolmanagement.entities;

public class Teacher extends User {
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
