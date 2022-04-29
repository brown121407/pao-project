package xyz._121407.schoolmanagement.repositories;

import xyz._121407.schoolmanagement.entities.Identifiable;
import xyz._121407.schoolmanagement.exceptions.RepositoryException;
import xyz._121407.schoolmanagement.services.EntityWriter;

import java.io.IOException;

public class CsvBackedRepository<T extends Identifiable> extends Repository<T> {
    private final EntityWriter writer = EntityWriter.getInstance();

    @Override
    public void create(T obj) {
        super.create(obj);

        try {
            writer.writeOne(obj);
        } catch (IOException exception) {
            var repoEx = new RepositoryException();
            repoEx.addSuppressed(exception);
            throw repoEx;
        }
    }

    @Override
    public void update(T obj) {
        super.update(obj);

        try {
            writer.writeAll(entities);
        } catch (IOException exception) {
            var repoEx = new RepositoryException();
            repoEx.addSuppressed(exception);
            throw repoEx;
        }
    }

    @Override
    public void delete(int id) {
        super.delete(id);

        try {
            writer.writeAll(entities);
        } catch (IOException exception) {
            var repoEx = new RepositoryException();
            repoEx.addSuppressed(exception);
            throw repoEx;
        }
    }
}
