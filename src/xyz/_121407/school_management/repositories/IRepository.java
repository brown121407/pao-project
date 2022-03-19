package xyz._121407.school_management.repositories;

import xyz._121407.school_management.entities.Identifiable;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public interface IRepository<T extends Identifiable> {
    void create(T obj);
    Set<T> getAll();
    T findFirst(Predicate<T> predicate);
    Set<T> findAll(Predicate<T> predicate);
    void update(T obj);
    void delete(int id);
}
