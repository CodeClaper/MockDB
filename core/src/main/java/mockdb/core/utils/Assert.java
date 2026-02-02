package mockdb.core.utils;

import static java.lang.String.format;

public class Assert {

    /**
     * Assert express is true.
     * @param expression    Express.
     * @param format        Format.
     * @param values        Values.
     */
    public static void isTrue(boolean expression, String format, Object... values) {
        if (!expression) {
            throw new RuntimeException(format(format, values));
        }
    }

    /**
     * Assert express is false.
     * @param expression    Express.
     * @param format        Format.
     * @param values        Values.
     */
    public static void isFalse(boolean expression, String format, Object... values) {
        if (expression) {
            throw new RuntimeException(format(format, values));
        }
    }

    /**
     * Assert object is null
     * @param object        Object
     * @param format        Format.
     * @param values        Values.
     */
    public static void isNull(Object object, String format, Object... values) {
        if (object != null) {
            throw new RuntimeException(format(format, values));
        }
    }

    /**
     * Assert object is not null
     * @param format        Format.
     * @param values        Values.
     */
    public static void notNull(Object object, String format, Object... values) {
        if (object == null) {
            throw new RuntimeException(format(format, values));
        }
    }
}
