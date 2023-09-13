package org.example.DAO;

import org.example.HibernateUtils.HibernateUtil;
import org.example.Model.Manufacture;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.management.openmbean.InvalidOpenTypeException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

public class ManufactureDAO implements Repository<Manufacture, String> {
    private static Session session;
    private static Transaction transaction;
    public static ManufactureDAO getInstance() {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = null;
        return new ManufactureDAO();
    }
    @Override
    public String add(Manufacture item) {
        try{
            transaction = session.beginTransaction();
            session.saveOrUpdate(item);
            transaction.commit();
            return "Add manufacture successfully";
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return "Add manufacture fail";
    }

    @Override
    public List<Manufacture> readAll() {
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Manufacture> cq = cb.createQuery(Manufacture.class);
        Root<Manufacture> rootEntry = cq.from(Manufacture.class);
        CriteriaQuery<Manufacture> all = cq.select(rootEntry);
        TypedQuery<Manufacture> allQuery = session.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public Manufacture read(String id) {
        try{
            transaction = session.beginTransaction();
            Manufacture manufacture = session.byId(Manufacture.class).getReference(id);
            transaction.commit();
            return manufacture;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(Manufacture item) {
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
            Manufacture manufacture =  session.get(Manufacture.class, id);
            if (manufacture != null) {
                session.delete(manufacture);
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
    public List<Manufacture> checkOver100Emp(){
        Query<Manufacture> query = session.createNativeQuery("SELECT * FROM Manufacture " +
                "where employee >100",Manufacture.class);
        if (query.getResultList().size()==0) return null;
        return query.getResultList();
    }
    public Integer sumAllEmployee(){
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Integer> cr = cb.createQuery(Integer.class);
        Root<Manufacture> root = cr.from(Manufacture.class);
        cr.select(cb.sum(root.get("employee")));
        Query<Integer> query = session.createQuery(cr);
        return query.getSingleResult();
    }
    public List<Manufacture> allManuInUS(){
        Query<Manufacture> query = session.createNativeQuery("SELECT * FROM Manufacture " +
                "where location = 'us'",Manufacture.class);
        if (query.getResultList().size()==0) {
            throw new InvalidOpenTypeException("No manufacture in US");
        }
        return query.getResultList();
    }
    }
