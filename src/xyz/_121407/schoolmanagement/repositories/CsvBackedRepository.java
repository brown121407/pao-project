package xyz._121407.schoolmanagement.repositories;

import xyz._121407.schoolmanagement.entities.Identifiable;
import xyz._121407.schoolmanagement.exceptions.RepositoryException;
import xyz._121407.schoolmanagement.services.EntityWriter;
import xyz._121407.schoolmanagement.services.logging.ActionType;
import xyz._121407.schoolmanagement.services.logging.Logger;
import xyz._121407.schoolmanagement.utils.EnglishFormatter;

import java.io.IOException;

public class CsvBackedRepository<T extends Identifiable> extends Repository<T> {
    private final EntityWriter writer = EntityWriter.getInstance();
    private final Logger logger = Logger.getInstance();
    private final Class<T> entityClass;

    public CsvBackedRepository(Class<?> klass) {
        super();

        entityClass = (Class<T>) klass;
    }

    @Override
    public void create(T obj) {
        super.create(obj);

        try {
            writer.writeOne(obj);
        } catch (IOException exception) {
            logger.log(ActionType.ERROR, "Failed to create a " + EnglishFormatter.toHumanReadable(entityClass));

            var repoEx = new RepositoryException();
            repoEx.addSuppressed(exception);
            throw repoEx;
        }

        logger.log(ActionType.CREATE, "Created a " + EnglishFormatter.toHumanReadable(entityClass));
    }

    @Override
    public void update(T obj) {
        super.update(obj);

        try {
            writer.writeAll(entityClass, entities);
        } catch (IOException exception) {
            logger.log(ActionType.ERROR, "Failed to update the "
                    + EnglishFormatter.toHumanReadable(entityClass)
                    + " with ID " + obj.getId());

            var repoEx = new RepositoryException();
            repoEx.addSuppressed(exception);
            throw repoEx;
        }

        logger.log(ActionType.UPDATE, "Updated the "
                + EnglishFormatter.toHumanReadable(entityClass)
                + " with ID " + obj.getId());
    }

    @Override
    public void delete(int id) {
        super.delete(id);

        try {
            writer.writeAll(entityClass, entities);
        } catch (IOException exception) {
            logger.log(ActionType.ERROR, "Failed to delete the "
                    + EnglishFormatter.toHumanReadable(entityClass)
                    + " with ID " + id);

            var repoEx = new RepositoryException();
            repoEx.addSuppressed(exception);
            throw repoEx;
        }

        logger.log(ActionType.UPDATE, "Updated the "
                + EnglishFormatter.toHumanReadable(entityClass)
                + " with ID " + id);
        logger.log(ActionType.DELETE, "Deleted an object with ID " + id);
    }
}
