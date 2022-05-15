package xyz._121407.schoolmanagement.entities;

import xyz._121407.schoolmanagement.annotations.Field;

public class Teacher extends User {
    @Field
    private int subjectId;
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
}
