package mockdb.exception;

public class DBClosedException extends RuntimeException {
    public DBClosedException(String message) {
        super(message);
    }
}
