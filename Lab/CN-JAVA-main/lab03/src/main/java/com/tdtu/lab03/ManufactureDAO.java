package com.tdtu.lab03;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManufactureDAO {
	Session session = HibernateUtils.getSessionFactory().openSession();
	
	public boolean add(Manufacture manufacture) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(manufacture);
			transaction.commit();
			return true;
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			return false;
		}
	}
	
	public Manufacture get(int id) {
		try {
			return (Manufacture) session.createQuery("from Manufacture e where e.id="+id).list().get(0);
		} catch(Exception e) {
			return null;
		}
	}
	
	public List<Manufacture> getAll() {
		try {
			return session.createQuery("from Manufacture").list();
		} catch(Exception e) {
			return null;
		}
	}
	
	public boolean remove(int id) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Manufacture manufacture = session.get(Manufacture.class, id);
			if(manufacture != null) {
				String hql = "DELETE FROM Manufacture " + "WHERE id = :manufactureId";
				Query query = session.createQuery(hql);
                query.setParameter("manufactureId", id);
				int result = query.executeUpdate();
				transaction.commit();
				if(result > 0) {
					return true;
				}
				return false;
			}
			return false;
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			return false;
		}
	}
	
	public boolean remove(Manufacture p) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Manufacture manufacture = session.get(Manufacture.class, p.getId());
			if(manufacture != null) {
				String hql = "DELETE FROM Manufacture " + "WHERE id = :manufactureId";
				Query query = session.createQuery(hql);
				query.setParameter("manafactureId", p.getId());
				int result = query.executeUpdate();
				transaction.commit();
				if(result > 0) {
					return true;
				}
				return false;
			}
			return false;
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			return false;
		}
	}
	
	public boolean update(Manufacture p) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			String hql = "UPDATE Manufacture set name = :name, location = :location, employee = :employee WHERE id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("name", p.getName());
			query.setParameter("location", p.getLocation());
			query.setParameter("employee", p.getEmployee());
			query.setParameter("id", p.getId());
			int result = query.executeUpdate();
			transaction.commit();
			if(result > 0) {
				return true;
			}
			return false;
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			return false;
		}
	}
	
	public boolean checkMoreThan100Employee() {
		for(Manufacture manufacture : this.getAll())
			if(manufacture.getEmployee() < 100)
				return false;
		return true;
	}
	
	public int countAllEmployee() {
		int result = 0;
		for(Manufacture manufacture : this.getAll())
			result += manufacture.getEmployee();
		return result;
	}
	
	public Manufacture checkInUS() throws Exception {
		try {
			return (Manufacture) session.createQuery("from Manufacture e where e.location='US' ORDER BY e.id DESC").list().get(0);
		} catch (Exception e) {
			throw new Exception("InvalidOperationException");
		}
	}
}
