package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    static ProductDAO productDAO;
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Connection connection = MySQLConnUtils.getConnection("");
            MySQLConnUtils.printInfo(connection);
            Statement st = connection.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS productManagement";
            st.execute(sql);
            MySQLConnUtils.closeConnection(connection);
            connection = MySQLConnUtils.getConnection("productManagement");
            st = connection.createStatement();
            sql = "CREATE TABLE IF NOT EXISTS PRODUCT (\n" +
                    "    id int(9) NOT NULL AUTO_INCREMENT, \n" +
                    "    name nvarchar(50) DEFAULT NULL, \n" +
                    "    price float  DEFAULT 0,\n" +
                    "    color nvarchar(10) DEFAULT NULL, \n" +
                    "    PRIMARY KEY(id)\n" +
                    ")  ENGINE = InnoDB DEFAULT CHARSET = latin1";
            st.execute(sql);
            MySQLConnUtils.closeConnection(connection);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

          productDAO = new ProductDAO();
//        productDAO.add(new Product("Iphone 11","Pink",1500000));
//        System.out.println(productDAO.readAll());
//        productDAO.update(new Product(1,"Iphone 11","Red",150000));
//        productDAO.delete(2);
//        System.out.println(productDAO.readAll());
          menu();
    }
//
//
//
//
//5. Delete a product
//6. Exit
    private static void printDefault() {
        System.out.println("\t\t\t\t\t\t\t\t MANAGE PRODUCT" + "\n" +
                "**************************************************************************" + "\n" +
                "**  1. Read product list                                                **" + "\n" +
                "**  2. Read a product by input id                                       **" + "\n" +
                "**  3. Add a new product, the result is the product id (auto increment) **" + "\n" +
                "**  4. Update a product                                                 **" + "\n" +
                "**  5. Delete a product                                                 **" + "\n" +
                "**  6. Exit.                                                            **" + "\n" +
                "**************************************************************************");
        System.out.print("Your choice: ");
    }

    public static void menu() {
        int number, id;
        String name, color;
        float price;
        do {
            printDefault();
            scan = new Scanner(System.in);
            number = scan.nextInt();
            switch (number) {
                case 1:
                    System.out.println(productDAO.readAll());
                    break;
                case 2:
                    System.out.println("Enter product's id: ");
                    id = scan.nextInt();
                    System.out.println(productDAO.read(id).toString());
                    break;
                case 3:
                    scan.nextLine();
                    System.out.println("Enter product's name: ");
                    name = scan.nextLine();
                    System.out.println("Enter product's price: ");
                    price = scan.nextFloat();
                    scan.nextLine();
                    System.out.println("Enter product's color: ");
                    color = scan.nextLine();
                    productDAO.add(new Product(name,color,price));
                    break;
                case 4:
                    System.out.println("Enter product's id need update: ");
                    id = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter product's new name: ");
                    name = scan.nextLine();
                    System.out.println("Enter product's new price: ");
                    price = scan.nextFloat();
                    scan.nextLine();
                    System.out.println("Enter product's new color: ");
                    color = scan.nextLine();
                    productDAO.update(new Product(id,name,color,price));
                    break;
                case 5:
                    System.out.println("Enter product's id: ");
                    id = scan.nextInt();
                    productDAO.delete(id);
                    break;
                default:
                    scan.close();
                    number = 6;
                    System.out.println("See you later!");
                    break;
            }
        } while (number != 6);
    }


}
