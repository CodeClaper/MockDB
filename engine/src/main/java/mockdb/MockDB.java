package mockdb;

import mockdb.exception.DBClosedException;
import mockdb.executor.Executor;
import mockdb.store.Database;
import mockdb.utils.Assert;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class MockDB implements Closeable {
    private final static AtomicReference<MockDB> instance = new AtomicReference<>();
    private final AtomicReference<Boolean> closed = new AtomicReference<>(true);
    private final AtomicReference<Database> defaultDatabase = new AtomicReference<>();
    private final AtomicReference<Executor> executor = new AtomicReference<>();
    private final Set<Database> databaseSet = Collections.newSetFromMap(new LinkedHashMap<>());

    public static MockDB startup() {
        if (instance.get() == null) {
            synchronized (instance) {
                if (instance.get() == null) {
                    instance.set(new MockDB());
                }
            }
        }
        return instance.get();
    }

    public MockDB use(String databaseName) {
        for (Database database : databaseSet) {
            if (database.getName().equals(databaseName)) {
                this.defaultDatabase.set(database);
                return this;
            }
        }
        Database database = new Database(databaseName);
        this.register(database);
        this.defaultDatabase.set(database);
        return this;
    }

    public void register(Database database) {
        Assert.isTrue(databaseSet.add(database), "Database %s already exists.", database.getName());
    }

    public Database getDefaultDatabase() {
        return this.defaultDatabase.get();
    }

    public Executor getExecutor() {
        this.checkOpen();
        return this.executor.get();
    }

    private MockDB() {
        this.executor.set(new Executor());
    }

    private void checkOpen() {
        if (!this.closed.get()) throw new DBClosedException("MockDB has closed.");
    }

    @Override
    public void close() throws IOException {
        instance.set(null);
        this.closed.set(true);
    }
}
