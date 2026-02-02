package mockdb.core.jdbc;
import junit.framework.TestCase;

public class DriverInfoTest extends TestCase {

    public void testDriverName() {
        assertEquals("MockDB JDBC Driver", DriverInfo.DRIVER_NAME);
    }

    public void testDriverVersion() {
        assertEquals("1.0", DriverInfo.DRIVER_VERSION);
        assertEquals(1, DriverInfo.DRIVER_VERSION_MAJOR);
        assertEquals(0, DriverInfo.DRIVER_VERSION_MINOR);
    }
}