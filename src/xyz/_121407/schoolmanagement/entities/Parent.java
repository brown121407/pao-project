package xyz._121407.schoolmanagement.entities;

import java.util.HashSet;
import java.util.Set;

public class Parent extends User {
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
