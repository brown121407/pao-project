package xyz._121407.auction_house.repositories;

import xyz._121407.auction_house.entities.IIdentifiable;
import xyz._121407.auction_house.exceptions.DuplicateKeyException;

import java.util.*;

public abstract class InMemoryRepository<T extends IIdentifiable<U>, U> implements IRepository<T, U> {
    protected List<T> entities = new ArrayList<>();

    @Override
    public Optional<T> get(U id) {
        return entities.stream().filter(x -> x.getId().equals(id)).findFirst();
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(entities);
    }

    @Override
    public void add(T entity) {
        if (entities.stream().anyMatch(x -> x.getId().equals(entity.getId()))) {
            throw new DuplicateKeyException("ID already exists.");
        }

        entities.add(entity);
    }

    @Override
    public void update(T payload) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i).getId().equals(payload.getId())) {
                entities.set(i, payload);
                break;
            }
        }
    }
}
