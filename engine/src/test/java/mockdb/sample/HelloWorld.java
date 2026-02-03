package mockdb.sample;

import mockdb.MockDB;
import mockdb.executor.Executor;

public class HelloWorld {

    public static void main(String[] args) {
        try (MockDB mockDB = MockDB.startup();
             Executor executor = mockDB.getExecutor()
        ) {
            executor.execute("create table Users(id int, name varchar(32), age int, sex char, address varchar(32),  primary key(id));");
            executor.execute("insert into Users values(1, 'bob', 12, 'M', 'Beijing, China')");
            executor.execute("select * from Users");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
