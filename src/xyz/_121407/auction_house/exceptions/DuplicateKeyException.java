package xyz._121407.auction_house.exceptions;

public class DuplicateKeyException extends RuntimeException {
    public DuplicateKeyException() {
        super();
    }

    public DuplicateKeyException(String message) {
        super(message);
    }
}
