package xyz._121407.school_management.entities;

import java.util.HashSet;
import java.util.Set;

public class Teacher extends User {
    private Set<Subject> subjects = new HashSet<>();

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}
