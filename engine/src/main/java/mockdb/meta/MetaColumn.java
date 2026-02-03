package mockdb.meta;

import lombok.Data;

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
