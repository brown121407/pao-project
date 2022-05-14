package xyz._121407.schoolmanagement.entities;

import xyz._121407.schoolmanagement.annotations.CsvReadable;
import xyz._121407.schoolmanagement.annotations.CsvWritable;

public class Subject implements Identifiable {
    private int id = 0;
    private String name;

    @CsvWritable(field = "name")
    public String getName() {
        return name;
    }

    @CsvReadable(field = "name")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    @CsvWritable(field = "id")
    public int getId() {
        return id;
    }

    @Override
    @CsvReadable(field = "id")
    public void setId(Integer id) {
        this.id = id;
    }
}
