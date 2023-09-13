package org.example.Test;

import org.example.DAO.ManufactureDAO;
import org.example.DAO.PhoneDAO;
import org.example.Model.Manufacture;
import org.example.Model.Phone;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // Test CURD
        ManufactureDAO manufactureDAO = ManufactureDAO.getInstance();
        manufactureDAO.add(new Manufacture("Manu01",109,"Marcus Rasford","Manchester"));
        manufactureDAO.add(new Manufacture("Manu02",80,"Lord Bener","US"));
        manufactureDAO.add(new Manufacture("Manu04",109,"Marcus Rasford","Manchester"));
        Manufacture manufacture = new Manufacture("Manu03",129,"Marcus Rasford","Manchester");
        manufactureDAO.add(manufacture);
        System.out.println(manufactureDAO.readAll());
        System.out.println(manufactureDAO.read("Manu01"));
        System.out.println(manufactureDAO.update(new Manufacture("Manu03",70,"Marcus Lord","US")));
        System.out.println(manufactureDAO.delete("Manu04"));
        // Test Query
        System.out.println(manufactureDAO.checkOver100Emp());
        System.out.println(manufactureDAO.sumAllEmployee());
        System.out.println(manufactureDAO.allManuInUS());
        manufactureDAO.close();

        // Test CURD
        PhoneDAO phoneDAO = PhoneDAO.getInstance();
        Phone phone = new Phone("phone01","Iphone 15","Black","America"
                ,8000000,600,manufacture);
        Phone phone1 = new Phone("phone02","Iphone 20","Pink","America"
                ,80000000,600,manufacture);
        Phone phone3 = new Phone("phone03","Iphone 20","Pink","America"
                ,80000000,600,manufacture);
        phoneDAO.add(phone);
        phoneDAO.add(phone1);
        phoneDAO.add(phone3);
        System.out.println(phoneDAO.readAll());
        System.out.println(phoneDAO.read("phone01"));
        System.out.println(phoneDAO.delete("phone3"));

        // Test Query
        System.out.println(phoneDAO.highestPrice());
        System.out.println(phoneDAO.sorted());
        System.out.println(phoneDAO.greater50M());
        System.out.println(phoneDAO.pinkColorAndGt15M());
        phoneDAO.close();
    }
}
