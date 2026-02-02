package mockdb.core.exceptions;

import java.sql.SQLException;

public class MockSQLException extends SQLException {

    public MockSQLException(String format, Object... values) {
        super(String.format(format, values));
    }

    public MockSQLException(Throwable cause, String format, Object... values) {
        super(String.format(format, values), cause);
    }
}
