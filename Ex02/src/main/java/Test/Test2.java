package Test;

import connection.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import com.mysql.cj.xdevapi.PreparableStatement;
public class Test2 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			Connection connection = MySQLConnection.getConnection();
			System.out.println(connection);
//			Statement stm = connection.createStatement();
//			String query = "Select * from student";
//			ResultSet result = stm.executeQuery(query);
//			while(result.next()) {
//				int ID = result.getInt("ID");
//				String name = result.getString("name");
//				String email = result.getString("email");
//				String phone = result.getString("phone");
//				
//				System.out.println("ID: "+ID+" Name: " + name + " email:  " +email + " phone : " + phone );
//			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
