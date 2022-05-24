package xyz._121407.schoolmanagement.entities;

import xyz._121407.schoolmanagement.annotations.*;

@Table
public class Student extends User {
    @Field
    @References(table = Class.class, field = "id")
    private int classId;

    @Navigation
    private Class klass;

    @Field
    @References(table = Parent.class, field = "id")
    private int parentId;

    @Navigation
    private Parent parent;

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

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
        this.parentId = parent.getId();
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
}
