package mockdb.exception;

public class UnsupportedColumnTypeException extends RuntimeException {
    public UnsupportedColumnTypeException(String message) {
        super(message);
    }
}
