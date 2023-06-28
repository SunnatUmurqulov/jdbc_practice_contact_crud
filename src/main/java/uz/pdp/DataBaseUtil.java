package uz.pdp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtil {
    public static void createTable(){
        String sql = "create table if not exists contact (" +
                "id serial primary key," +
                "name varchar(25) not null," +
                "surname varchar(25) not null," +
                "phone varchar(12) not null unique" +
                ")";

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/clone_olx",
                    "postgres", "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
