package mockdb.parser;

import mockdb.exception.SQLSyntaxException;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;

public class Jparser {

    public static Statement parse(String sql) {
        try {
            return CCJSqlParserUtil.parse(sql);
        } catch (JSQLParserException e) {
            throw new SQLSyntaxException(e);
        }
    }
}
