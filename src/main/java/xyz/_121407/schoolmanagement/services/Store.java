package xyz._121407.schoolmanagement.services;

import xyz._121407.schoolmanagement.entities.*;
import xyz._121407.schoolmanagement.entities.Class;
import xyz._121407.schoolmanagement.repositories.CsvBackedRepository;
import xyz._121407.schoolmanagement.repositories.DBBackedRepository;
import xyz._121407.schoolmanagement.repositories.IRepository;
import xyz._121407.schoolmanagement.repositories.Repository;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private static Store instance;

    private final Map<java.lang.Class<?>, IRepository<Identifiable>> repositoryMap = new HashMap<>();

    private Store() {
        repositoryMap.put(Subject.class, new DBBackedRepository<>(Subject.class));
        repositoryMap.put(Profile.class, new DBBackedRepository<>(Profile.class));
        repositoryMap.put(Room.class, new DBBackedRepository<>(Room.class));
        repositoryMap.put(Class.class, new DBBackedRepository<>(Class.class));
        repositoryMap.put(Address.class, new DBBackedRepository<>(Address.class));
        repositoryMap.put(Student.class, new DBBackedRepository<>(Student.class));
        repositoryMap.put(Teacher.class, new DBBackedRepository<>(Teacher.class));
        repositoryMap.put(Parent.class, new DBBackedRepository<>(Parent.class));
    }

    public static Store getInstance() {
        if (instance == null) {
            instance = new Store();
        }

        return instance;
    }

    public <T extends Identifiable> IRepository<T> get(java.lang.Class<T> klass) {
        return (IRepository<T>) repositoryMap.get(klass);
    }
}
