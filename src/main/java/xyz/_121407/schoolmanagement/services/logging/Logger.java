package xyz._121407.schoolmanagement.services.logging;

import xyz._121407.schoolmanagement.services.EntityWriter;

import java.io.IOException;

public class Logger {
    private static Logger instance;
    private final EntityWriter writer = EntityWriter.getInstance();

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }

        return instance;
    }

    public void log(ActionType type, String message) {
        try {
            writer.writeOne(new Log(type, message));
        } catch (IOException e) {
            System.err.println("Failed to write logs. Something is probably really broken!");
            e.printStackTrace();
        }
    }
}
