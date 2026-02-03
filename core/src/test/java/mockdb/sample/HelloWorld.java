package mockdb.sample;

import java.sql.*;

public class HelloWorld {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("mockdb.core.jdbc.MockDriver");
        try (Connection conn = DriverManager.getConnection("jdbc:mockdb:test");
             Statement stat = conn.createStatement())
        {
            stat.execute("create table test(id int primary key, name varchar(255))");
            stat.execute("insert into test values(1, 'Hello')");
            ResultSet rs;
            rs = stat.executeQuery("select * from test");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }
    }
}
