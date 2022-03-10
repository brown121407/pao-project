package xyz._121407.school_management.entities;

import java.util.HashSet;
import java.util.Set;

public class HighSchool {
    private String name;
    private Address address;

    private final Set<Teacher> teachers = new HashSet<>();
    private final Set<Room> rooms = new HashSet<>();
    private final Set<Class> classes = new HashSet<>();
    private final Set<Profile> profiles = new HashSet<>();
}
