package mockdb.store;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class Database {
    private final AtomicReference<String> databaseName = new AtomicReference<>();
    private final Set<Table> tableList = Collections.newSetFromMap(new ConcurrentHashMap<>());

    public Database(String databaseName) {
        this.databaseName.set(databaseName);
    }

    public boolean createTable(Table table) {
        return tableList.add(table);
    }

    public String getName() {
        return this.databaseName.get();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Database) {
            return ((Database) obj).getName().equals(this.getName());
        } else
            return obj.equals(this);
    }
}
