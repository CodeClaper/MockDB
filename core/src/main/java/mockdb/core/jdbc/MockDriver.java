package mockdb.core.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MockDriver extends MockNonRegisteringDriver {
    static {
        try {
            DriverManager.registerDriver(new MockDriver());
        } catch (SQLException e) {
            Logger.getLogger(MockDriver.class.getPackage().getName())
                    .log(Level.SEVERE, "Failed to register mock driver", e);
            throw new RuntimeException(e);
        }
    }
}
