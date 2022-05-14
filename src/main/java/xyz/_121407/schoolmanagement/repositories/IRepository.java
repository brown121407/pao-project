package xyz._121407.schoolmanagement.repositories;

import xyz._121407.schoolmanagement.entities.Identifiable;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public interface IRepository<T extends Identifiable> {
    void seed(List<T> entities);
    void create(T obj);
    Set<T> getAll();
    List<T> getAllSortedBy(Comparator<T> comparator);
    T findFirst(Predicate<T> predicate);
    Set<T> findAll(Predicate<T> predicate);
    void update(T obj);
    void delete(int id);
    void setNextId(int nextId);
}
