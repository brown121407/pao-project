package xyz._121407.schoolmanagement.entities;

import xyz._121407.schoolmanagement.annotations.*;

@Table
public class Student extends User {
    private Class klass;

    @Field
    @References(table = Class.class, field = "id")
    private int classId;

    @FieldWriter(field = "classId")
    public int getClassId() {
        return classId;
    }

    @FieldReader(field = "classId")
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Class getKlass() {
        return klass;
    }

    public void setKlass(Class klass) {
        this.klass = klass;
        this.classId = klass.getId();
    }
}
