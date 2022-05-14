package xyz._121407.schoolmanagement.repositories;

import xyz._121407.schoolmanagement.entities.Identifiable;
import xyz._121407.schoolmanagement.services.Database;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class DBBackedRepository<T extends Identifiable> implements IRepository<T> {
    @Override
    public void seed(List<T> entities) {

    }

    @Override
    public void create(T obj) {
        var connection = Database.getConnection();

    }

    @Override
    public Set<T> getAll() {
        return null;
    }

    @Override
    public List<T> getAllSortedBy(Comparator<T> comparator) {
        return null;
    }

    @Override
    public T findFirst(Predicate<T> predicate) {
        return null;
    }

    @Override
    public Set<T> findAll(Predicate<T> predicate) {
        return null;
    }

    @Override
    public void update(T obj) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void setNextId(int nextId) {

    }
}
