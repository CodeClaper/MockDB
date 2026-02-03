package mockdb.statements;

import junit.framework.TestCase;
import mockdb.executor.Executor;

public class CreateTest extends TestCase {

    public void testCreateTable() {
        String sql = "create table users(id int primary key, name varchar(32), sex int, address varchar(125));";
        Executor executor = new Executor();
        Object ret = executor.execute(sql);
        assertNotNull(ret);
    }
}