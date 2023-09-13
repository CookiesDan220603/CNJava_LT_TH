package connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
public class MySQLConnection {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		String hostname = "localhost";
		String dbname = "qlsv";
		String userName = "root1";
		String password = "123";
		return getConnection(hostname, dbname,userName,password);
		
	}
	public static Connection getConnection(String hostname,String dbname, String userName,String password) throws ClassNotFoundException,SQLException{
		String conURL = "jdbc:mysql://" + hostname +":3306/"+dbname;
		Connection conn = DriverManager.getConnection(conURL, userName, password);
		return conn;
	}
}
