package xyz._121407.auction_house.repositories;

import java.util.List;
import java.util.Optional;

public interface IRepository<T, U> {
    Optional<T> get(U id);
    List<T> getAll();
    void add(T entity);
    void update(T payload);
}
