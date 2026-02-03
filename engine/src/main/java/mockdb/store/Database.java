package mockdb.store;

import lombok.Data;

import java.util.List;

@Data
public class Database {
    private String databaseName;
    private List<Table> tableList;
}
