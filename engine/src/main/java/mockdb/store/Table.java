package mockdb.store;

import lombok.Data;
import lombok.experimental.Accessors;
import mockdb.meta.MetaTable;

@Data
@Accessors(chain = true)
public class Table {
    private MetaTable metaTable;
    private Pager pager;
}
