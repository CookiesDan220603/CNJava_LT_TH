package com.example.lab05.DAO;

import com.example.lab05.utils.HibernateUtils;
import com.example.lab05.Model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
public class UserDAO {
    private static Session session;
    private static Transaction transaction;
    public static UserDAO getInstance() {
        session = HibernateUtils.getSessionFactory().openSession();
        transaction = null;
        return new UserDAO();
    }
    public boolean add(User item) {
        try{
            transaction = session.beginTransaction();
            session.saveOrUpdate(item);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
    public User read(String username) {
        try{
            transaction = session.beginTransaction();
            User user = session.get(User.class,username);
            transaction.commit();
            return user;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return new User();
        }
    }
    public void  close(){
        session.close();
    }
}
