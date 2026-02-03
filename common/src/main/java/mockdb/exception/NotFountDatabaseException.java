package mockdb.exception;

public class NotFountDatabaseException extends RuntimeException {
    public NotFountDatabaseException(String message) {
        super(message);
    }
}
