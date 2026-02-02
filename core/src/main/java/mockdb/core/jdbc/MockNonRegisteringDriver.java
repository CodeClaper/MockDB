package mockdb.jdbc;

import java.io.Closeable;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class MockNonRegisteringDriver implements Driver, Closeable {
    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        if (this.acceptsURL(url)) return null;
        return new MockConnector();
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        if (url == null) throw new SQLException("URL is null");
        return MockDriverUri.acceptsURL(url);
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return DriverInfo.DRIVER_VERSION_MAJOR;
    }

    @Override
    public int getMinorVersion() {
        return DriverInfo.DRIVER_VERSION_MINOR;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public void close() throws IOException {

    }
}
