package mockdb.core.jdbc;

import junit.framework.TestCase;

public class MockDriverTest extends TestCase {

    public void testDriverLoader() throws ClassNotFoundException {
        Class.forName("mockdb.core.jdbc.MockDriver");
    }
}