package xyz._121407.schoolmanagement.services.logging;

import xyz._121407.schoolmanagement.annotations.FieldWriter;

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

    @FieldWriter(field = "type")
    public ActionType getActionType() {
        return actionType;
    }

    @FieldWriter(field = "timestamp")
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @FieldWriter(field = "message")
    public String getMessage() {
        return message;
    }
}
