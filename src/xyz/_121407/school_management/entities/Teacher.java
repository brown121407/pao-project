package xyz._121407.school_management.entities;

import java.util.HashSet;
import java.util.Set;

public class Teacher extends User {
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
