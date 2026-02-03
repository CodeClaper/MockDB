package mockdb.meta;

import lombok.Data;
import lombok.experimental.Accessors;
import net.sf.jsqlparser.statement.create.table.ColDataType;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;

@Data
@Accessors(chain = true)
public class MetaColumn {
    private String columnName;
    private ColumnType columnType;
    private int columnLength;
    private boolean isPri;
    private boolean isUnique;
    private boolean sysReserved;
    private Object defaultValue;
    private String comments;

}
