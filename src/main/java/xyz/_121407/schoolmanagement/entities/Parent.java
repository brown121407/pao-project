package xyz._121407.schoolmanagement.entities;

import xyz._121407.schoolmanagement.annotations.Field;
import xyz._121407.schoolmanagement.annotations.Table;

import java.util.HashSet;
import java.util.Set;

@Table
public class Parent extends User {
    @Field
    private String phoneNumber;
    private Set<Student> children = new HashSet<>();

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Student> getChildren() {
        return children;
    }

    public void setChildren(Set<Student> children) {
        this.children = children;
    }
}
