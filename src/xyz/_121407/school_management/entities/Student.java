package xyz._121407.school_management.entities;

public class Student extends User {
    private Class klass;

    public Class getKlass() {
        return klass;
    }

    public void setKlass(Class klass) {
        this.klass = klass;
    }
}
