package mockdb.executor;

import mockdb.exception.UnsupportedSQLStatementException;
import mockdb.parser.Jparser;
import mockdb.statements.CreateStatement;
import mockdb.statements.InsertStatement;
import mockdb.statements.SelectStatement;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.PlainSelect;

import java.io.Closeable;
import java.io.IOException;

public class Executor implements Closeable {

    public final Object execute(String sql) {
        Statement statement = Jparser.parse(sql);
        if (statement instanceof CreateTable) return new CreateStatement().execute(statement);
        else if (statement instanceof PlainSelect) return new SelectStatement().execute(statement);
        else if (statement instanceof Insert) return new InsertStatement().execute(statement);
        else throw new UnsupportedSQLStatementException("Unsupported SQL statement: %s", sql);
    }

    @Override
    public void close() throws IOException {

    }
}
