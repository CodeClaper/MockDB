package mockdb.executor;

import mockdb.parser.Jparser;
import mockdb.statements.Create;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.create.table.CreateTable;

public class Executor {

    public Object execute(String sql) {
        Statement statement = Jparser.parse(sql);
        if (statement instanceof CreateTable) return new Create().createTable(statement);
        return null;
    }

}
