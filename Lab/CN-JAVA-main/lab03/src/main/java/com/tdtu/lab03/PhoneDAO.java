package com.tdtu.lab03;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

public class PhoneDAO {
	Session session = HibernateUtils.getSessionFactory().openSession();
	
	public boolean add(Phone phone) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(phone);
			transaction.commit();
			return true;
		} catch(Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
			return false;
		}
	}
	
	public Phone get(int id) {
		try {
			return (Phone) session.createQuery("from Phone e where e.id="+id).list().get(0);
		} catch(Exception e) {
			return null;
		}
	}
	
	public List<Phone> getAll() {
		try {
			return session.createQuery("from Phone").list();
		} catch(Exception e) {
			return null;
		}
	}
	
	public boolean remove(int id) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Phone phone = session.get(Phone.class, id);
			if(phone != null) {
				String hql = "DELETE FROM Phone " + "WHERE id = :phoneId";
				Query query = session.createQuery(hql);
				query.setParameter("phoneId", id);
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
			Phone phone = session.get(Phone.class, p.getId());
			if(phone != null) {
				String hql = "DELETE FROM Phone " + "WHERE id = :phoneId";
				Query query = session.createQuery(hql);
				query.setParameter("phoneId", p.getId());
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
	
	public boolean update(Phone p) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Query query = session.createQuery("UPDATE Phone set name = :name, price = :price, color = :color, country = :country, quantity = :quantity WHERE id = :id");
			query.setParameter("name", p.getName());
			query.setParameter("price", p.getPrice());
			query.setParameter("color", p.getColor());
			query.setParameter("country", p.getCountry());
			query.setParameter("quantity", p.getQuantity());
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
	
//	@SuppressWarnings("deprecation")
	public Phone getHighestSellingPrice() {
		try {
			return (Phone) session.createCriteria(Phone.class).addOrder(Order.desc("price")).setMaxResults(1).uniqueResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	public List<Phone> sortByCountryName() {
		try {
			return session.createCriteria(Phone.class).addOrder(Order.asc("country")).addOrder(Order.desc("price")).list();
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean checkAbove50M() {
		try {
			return ((Phone) session.createQuery("from Phone where price > 50000000").list().get(0)).getPrice() > 0 ? true : false;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Phone getPinkAndOver15M() {
		try {
			return (Phone) session.createQuery("from Phone e where color = 'Pink' AND price > 15000000").list().get(0);
		} catch (Exception e) {
			return null;
		}
	}
}
