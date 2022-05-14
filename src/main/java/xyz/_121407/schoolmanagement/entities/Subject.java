package xyz._121407.schoolmanagement.entities;

import xyz._121407.schoolmanagement.annotations.Field;
import xyz._121407.schoolmanagement.annotations.FieldReader;
import xyz._121407.schoolmanagement.annotations.FieldWriter;
import xyz._121407.schoolmanagement.annotations.Table;

@Table
public class Subject implements Identifiable {
    @Field(primaryKey = true)
    private int id = 0;

    @Field
    private String name;

    @FieldWriter(field = "name")
    public String getName() {
        return name;
    }

    @FieldReader(field = "name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    @FieldWriter(field = "id")
    public int getId() {
        return id;
    }

    @Override
    @FieldReader(field = "id")
    public void setId(Integer id) {
        this.id = id;
    }
}
