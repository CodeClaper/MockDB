package mockdb.parser;

import junit.framework.TestCase;
import net.sf.jsqlparser.statement.Statement;


public class JparserTest extends TestCase {

    public void testParse() {
        Jparser jparser = new Jparser();
        Statement statement = jparser.parse("select * from users where id = 'S001'");
        assertNotNull(statement);
    }
}