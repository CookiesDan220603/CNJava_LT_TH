package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {
    public static Connection getConnection(String nameDB) {
        Connection con=null;
        try {
            //Đăng ký MySQL Driver với DriverManager
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            //Các thông số
            String url="jdbc:mySQL://localhost:3306/"+nameDB;
            String username="root";
            String password="";

            //Tạo kết nối
            con=DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return con;

    }
    public static void closeConnection(Connection con) {
        try {
            if (con!=null) {
                con.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void printInfo(Connection con) {
        try {
            if(con!=null) {
                System.out.println(con.getMetaData().getDatabaseProductName().toString());
                System.out.println(con.getMetaData().getDatabaseProductVersion().toString());
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

