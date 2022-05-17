package xyz._121407.schoolmanagement.entities;

import xyz._121407.schoolmanagement.annotations.CsvReadable;
import xyz._121407.schoolmanagement.annotations.CsvWritable;

public class Student extends User {
    private Class klass;
    private int classId;

    @CsvWritable(field = "classId")
    public int getClassId() {
        return classId;
    }

    @CsvReadable(field = "classId")
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
