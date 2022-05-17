package xyz._121407.schoolmanagement.services.logging;

import xyz._121407.schoolmanagement.annotations.CsvWritable;

import java.time.LocalDateTime;

public class Log {
    private final ActionType actionType;
    private final LocalDateTime timestamp;
    private final String message;

    public Log(ActionType type, String message) {
        this.actionType = type;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    @CsvWritable(field = "type")
    public ActionType getActionType() {
        return actionType;
    }

    @CsvWritable(field = "timestamp")
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @CsvWritable(field = "message")
    public String getMessage() {
        return message;
    }
}
