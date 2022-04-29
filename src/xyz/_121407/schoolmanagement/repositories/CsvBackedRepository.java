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

    @Override
    public void create(T obj) {
        super.create(obj);

        try {
            writer.writeOne(obj);
        } catch (IOException exception) {
            logger.log(ActionType.ERROR, "Failed to create a " + EnglishFormatter.toHumanReadable(obj.getClass()));

            var repoEx = new RepositoryException();
            repoEx.addSuppressed(exception);
            throw repoEx;
        }

        logger.log(ActionType.CREATE, "Created a " + EnglishFormatter.toHumanReadable(obj.getClass()));
    }

    @Override
    public void update(T obj) {
        super.update(obj);

        try {
            writer.writeAll(entities);
        } catch (IOException exception) {
            logger.log(ActionType.ERROR, "Failed to update the "
                    + EnglishFormatter.toHumanReadable(obj.getClass())
                    + " with ID " + obj.getId());

            var repoEx = new RepositoryException();
            repoEx.addSuppressed(exception);
            throw repoEx;
        }

        logger.log(ActionType.UPDATE, "Updated the "
                + EnglishFormatter.toHumanReadable(obj.getClass())
                + " with ID " + obj.getId());
    }

    @Override
    public void delete(int id) {
        super.delete(id);

        try {
            writer.writeAll(entities);
        } catch (IOException exception) {
            logger.log(ActionType.ERROR, "Failed to delete an object with ID " + id);

            var repoEx = new RepositoryException();
            repoEx.addSuppressed(exception);
            throw repoEx;
        }

        // TODO: Find a way to get class from Set<T>
        logger.log(ActionType.DELETE, "Deleted an object with ID " + id);
    }
}
