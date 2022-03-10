package xyz._121407.school_management.entities;

import java.util.HashSet;
import java.util.Set;

public class Parent extends User {
    private String phoneNumber;
    private final Set<Student> children = new HashSet<>();
}
