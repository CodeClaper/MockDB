package mockdb.meta;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class MetaIndex {
    private String indexName;
    private IndexType indexType;
    private List<MetaColumn> columnList;
    private boolean isPri;
    private boolean isUnique;
}
