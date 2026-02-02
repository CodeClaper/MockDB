package mockdb.core.jdbc;

import mockdb.core.exceptions.MockSQLException;
import org.apache.commons.lang3.StringUtils;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;

public final class MockDriverUri {
    private static final String JDBC_URL_PREFIX = "jdbc:";
    private static final String JDBC_URL_START = JDBC_URL_PREFIX + "mockdb:";

    public static boolean acceptsURL(String url) {
        return url.startsWith(JDBC_URL_START);
    }

    private static URI parseDriverUrl(String url) throws SQLException {
        if (!url.startsWith(JDBC_URL_START)) throw new MockSQLException("Invalid JDBC URL: %s", url);
        if (url.equals(JDBC_URL_START)) throw new MockSQLException("Empty JDBC URL: %s", url);
        URI uri;
        try {
            uri = new URI(url.substring(JDBC_URL_PREFIX.length()));
        } catch (URISyntaxException e) {
            throw new MockSQLException(e, "Invalid JDBC URL: %s", url);
        }

        if (StringUtils.isBlank(uri.getHost())) throw new MockSQLException("No host specified: %s", url);
        if (uri.getPort() == -1) throw new MockSQLException("No port number specified: %s", url);
        if ((uri.getPort() < 1) || (uri.getPort() > 65535)) throw new MockSQLException("Invalid port number: %s", url);
        return uri;
    }
}
