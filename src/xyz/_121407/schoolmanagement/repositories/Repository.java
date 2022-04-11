package xyz._121407.schoolmanagement.repositories;

import xyz._121407.schoolmanagement.entities.Identifiable;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repository<T extends Identifiable> implements IRepository<T> {
    private final Set<T> entities = new HashSet<>();

    @Override
    public void create(T obj) {
        obj.setId(obj.nextId());
        entities.add(obj);
    }

    @Override
    public Set<T> getAll() {
        return entities;
    }

    @Override
    public List<T> getAllSortedBy(Comparator<T> comparator) {
        return entities.stream().sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public T findFirst(Predicate<T> predicate) {
        return entities.stream().filter(predicate).findFirst().orElse(null);
    }

    @Override
    public Set<T> findAll(Predicate<T> predicate) {
        return entities.stream().filter(predicate).collect(Collectors.toSet());
    }

    public void update(T obj) {
        entities.removeIf(x -> x.getId() == obj.getId());
        entities.add(obj);
    }

    @Override
    public void delete(int id) {
        entities.removeIf(x -> x.getId() == id);
    }
}
