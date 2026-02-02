package mockdb.core.jdbc;

public final class MockDriverUri {
    private static final String JDBC_URL_PREFIX = "mockdb:";


    public static boolean acceptsURL(String url) {
        return url.startsWith(JDBC_URL_PREFIX);
    }
}
