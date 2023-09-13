package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements Repository<Product,Integer>{
    @Override
    public Integer add(Product item) {
        try {
            Connection con = MySQLConnUtils.getConnection("ProductManagement");
            String query = "INSERT INTO product(name,price,color) values(?,?,?)";
            PreparedStatement ptm = con.prepareStatement(query);
            ptm.setString(1, item.name);
            ptm.setFloat(2, item.price);
            ptm.setString(3, item.color);
            ptm.execute();
            MySQLConnUtils.closeConnection(con);
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
        return 1;
    }

    @Override
    public List<Product> readAll() {
        List<Product> list = new ArrayList<>();
        try {
            Connection con = MySQLConnUtils.getConnection("productManagement");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from product");
            while (rs.next())
                list.add( new Product(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getFloat(3)));
                MySQLConnUtils.closeConnection(con);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return list;
    }

    @Override
    public Product read(Integer id) {
        Product product = new Product();
        try {
            Connection con = MySQLConnUtils.getConnection("productManagement");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from product where id = "+id);
            while (rs.next()){
                product  = new Product(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getFloat(3));
            }
            MySQLConnUtils.closeConnection(con);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return product;
    }

    @Override
    public boolean update(Product item) {
        Product product = read(item.id);
        if (product.id == 0) {
            return false;
        }
        String query = "UPDATE product SET name=?, price=?, color=? WHERE id = " + item.id;
        try {
            Connection con = MySQLConnUtils.getConnection("ProductManagement");
            PreparedStatement ptm = con.prepareStatement(query);
            ptm.setString(1, item.name);
            ptm.setFloat(2, item.price);
            ptm.setString(3, item.color);
            ptm.execute();
            MySQLConnUtils.closeConnection(con);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        Product product = read(id);
        if (product.id == 0) {
            return false;
        }
        String query = "DELETE FROM product WHERE id = " + id;
        try {
            Connection con = MySQLConnUtils.getConnection("ProductManagement");
            PreparedStatement ptm = con.prepareStatement(query);
            ptm.execute();
            MySQLConnUtils.closeConnection(con);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
