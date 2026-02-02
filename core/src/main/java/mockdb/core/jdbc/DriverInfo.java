package mockdb.core.jdbc;

import mockdb.core.utils.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public final class DriverInfo {
    static final String DRIVER_NAME;
    static final String DRIVER_VERSION;
    static final int DRIVER_VERSION_MAJOR;
    static final int DRIVER_VERSION_MINOR;

    static {
        try {
            Properties properties = new Properties();
            URL url = DriverInfo.class.getResource("/driver.properties");
            Assert.notNull(url, "driver.properties not found.");
            try (InputStream in = url.openStream()) {
                properties.load(in);
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }

            DRIVER_NAME = properties.getProperty("driverName");
            DRIVER_VERSION = properties.getProperty("driverVersion");
            Matcher matcher = Pattern.compile("^(\\d+)(\\.(\\d+))?($|[.-])").matcher(DRIVER_VERSION);
            Assert.isTrue(matcher.find(), "driverVersion is invalid: %s", DRIVER_VERSION);

            DRIVER_VERSION_MAJOR = parseInt(matcher.group(1));
            DRIVER_VERSION_MINOR = parseInt(matcher.group(3));
        } catch (RuntimeException e) {
            Logger.getLogger(DriverInfo.class.getPackage().getName())
                    .log(Level.SEVERE, "Failed to load driver info", e);
            throw e;
        }
    }
}
