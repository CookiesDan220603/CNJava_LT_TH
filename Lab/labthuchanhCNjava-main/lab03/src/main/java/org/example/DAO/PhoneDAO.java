package org.example.DAO;

import org.example.HibernateUtils.HibernateUtil;
import org.example.Model.Phone;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Objects;

public class PhoneDAO implements Repository<Phone, String>{
    private static Session session;
    private static Transaction transaction;
    public static PhoneDAO getInstance() {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = null;
        return new PhoneDAO();
    }
    @Override
    public String add(Phone item) {
        try{
            transaction = session.beginTransaction();
            session.saveOrUpdate(item);
            transaction.commit();
            return "Add phone successfully";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return "Add phone fail";
    }

    @Override
    public List<Phone> readAll() {
        Criteria criteria = session.createCriteria(Phone.class)
                .setFetchMode("phone", FetchMode.JOIN);
        return criteria.list();
    }

    @Override
    public Phone read(String id) {
        try{
            transaction = session.beginTransaction();
            Phone phone = session.byId(Phone.class).getReference(id);
            transaction.commit();
            return phone;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Phone item) {
        if(Objects.equals(null, item)){
            return false;
        }
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

    @Override
    public boolean delete(String id) {
        try{
            transaction = session.beginTransaction();
            Phone phone =  session.get(Phone.class, id);
            if (phone != null) {
                session.delete(phone);
                transaction.commit();
                return true;
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }
    public void close(){
        session.close();
    }
    public List<Phone> highestPrice(){
        Query<Phone> query = session.createNativeQuery("SELECT * FROM MobilePhone WHERE " +
                "price = (SELECT MAX(price) FROM MobilePhone)",Phone.class);
        return query.getResultList();
    }
    public List<Phone> sorted(){
        Query<Phone> query = session.createNativeQuery("SELECT * FROM MobilePhone " +
                "ORDER BY country ASC, price DESC",Phone.class);
        return query.getResultList();
    }
    public List<Phone> greater50M(){
        Query<Phone> query = session.createNativeQuery("SELECT * FROM MobilePhone " +
                "where price >50000000",Phone.class);
        return query.getResultList();
    }
    public List<Phone> pinkColorAndGt15M(){
        Query<Phone> query = session.createNativeQuery("SELECT * FROM MobilePhone " +
                "where price >1500000 and color = 'pink'",Phone.class);
        if (query.getResultList().size()==0) return null;
        return query.getResultList();
    }
    }