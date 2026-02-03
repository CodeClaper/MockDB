package mockdb.exception;

public class UnsupportedSQLStatementException extends RuntimeException {
    public UnsupportedSQLStatementException(String format, Object... values) {
        super(String.format(format, values));
    }
}
