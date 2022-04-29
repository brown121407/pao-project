package xyz._121407.schoolmanagement.services;

import xyz._121407.schoolmanagement.entities.*;
import xyz._121407.schoolmanagement.entities.Class;
import xyz._121407.schoolmanagement.repositories.IRepository;
import xyz._121407.schoolmanagement.repositories.Repository;

import java.util.HashMap;
import java.util.Map;

public class Store {
    private static Store instance;

    private final Map<java.lang.Class<?>, IRepository<Identifiable>> repositoryMap = new HashMap<>();

    private Store() {
        repositoryMap.put(Subject.class, new Repository<>());
        repositoryMap.put(Profile.class, new Repository<>());
        repositoryMap.put(Room.class, new Repository<>());
        repositoryMap.put(Class.class, new Repository<>());
        repositoryMap.put(Student.class, new Repository<>());
        repositoryMap.put(Teacher.class, new Repository<>());
        repositoryMap.put(Parent.class, new Repository<>());
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
