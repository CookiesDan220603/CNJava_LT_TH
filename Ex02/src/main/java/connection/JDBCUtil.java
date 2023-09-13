package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

    public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
        String hostName = "localhost";
        String dbName = "qlsv";
        String userName = "root1";
        String password = "123";
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName,String userName, String password) throws SQLException,
            ClassNotFoundException {
        // Cấu trúc URL Connection dành cho MySQL
        // Ví dụ: jdbc:mysql://localised:3306/simplehr
        String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;

        Connection conn = DriverManager.getConnection(connectionURL, userName,
                password);
        return conn;
    }
}