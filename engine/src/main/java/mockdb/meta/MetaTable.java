package mockdb.meta;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class MetaTable {
    private String tableName;
    private List<MetaColumn> metaColumnList;
}
