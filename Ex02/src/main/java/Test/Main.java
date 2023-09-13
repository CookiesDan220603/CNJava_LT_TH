package Test;

import connection.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;
public class Main {
    public static void main(String[] args) {
        try {
            // Lấy kết nối tới cơ sở dữ liệu MySQL bằng cách gọi phương thức từ JDBCUtil
            Connection connection = JDBCUtil.getMySQLConnection();
            String query = "INSERT into student (id,name,email,phone)" + "VALUE(null,?,?,?)";
//            PreparedStatement pstm = null;
//            try {
//            	pstm = connection.prepareStatement(query);
//            	pstm.setString(1,"Huy");
//            	pstm.setString(2, "huytruong@gmail.com");
//            	pstm.setString(3, "0939726205");
//            }
//            catch(SQLException e) {
//            	e.printStackTrace();
//            }
            // Sử dụng kết nối tại đây
            Statement stm = connection.createStatement();
            query = "Select * from student";
            ResultSet result = stm.executeQuery(query);
            
            while (result.next()) {
                // Lấy dữ liệu từ mỗi dòng kết quả
            	int ID = result.getInt("ID");
                String studentName = result.getString("name");
                String email = result.getString("email");
                String phone = result.getString("phone");

                // In ra thông tin sinh viên
                System.out.println("ID: "+ID+" Name: " + studentName + "email:  " +email + " phone : " + phone );
            }

            // Đóng kết nối sau khi sử dụng xong
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}