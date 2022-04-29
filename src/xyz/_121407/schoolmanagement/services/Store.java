package xyz._121407.schoolmanagement.services;

import xyz._121407.schoolmanagement.entities.*;
import xyz._121407.schoolmanagement.entities.Class;
import xyz._121407.schoolmanagement.repositories.IRepository;
import xyz._121407.schoolmanagement.repositories.Repository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryStore {
    private static InMemoryStore instance;

    private final Map<java.lang.Class<?>, IRepository<Identifiable>> repositoryMap = new HashMap<>();

    private InMemoryStore() {
        repositoryMap.put(Subject.class, new Repository<>());
    }

    public static InMemoryStore getInstance() {
        if (instance == null) {
            instance = new InMemoryStore();
        }

        return instance;
    }

    public <T extends Identifiable> IRepository<T> get(java.lang.Class<T> klass) {
        return (IRepository<T>) repositoryMap.get(klass);
    }
}
