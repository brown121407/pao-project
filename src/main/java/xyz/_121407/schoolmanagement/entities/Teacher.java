package xyz._121407.schoolmanagement.entities;

import xyz._121407.schoolmanagement.annotations.Field;
import xyz._121407.schoolmanagement.annotations.Navigation;
import xyz._121407.schoolmanagement.annotations.References;
import xyz._121407.schoolmanagement.annotations.Table;

@Table
public class Teacher extends User {
    @Field
    @References(table = Subject.class, field = "id")
    private int subjectId;

    @Navigation
    private Subject subject;

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
        this.subjectId = subject.getId();
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
}
