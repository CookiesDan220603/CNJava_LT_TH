package test;

//import java.math.BigDecimal;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import database.HibernateUtils;
import org.hibernate.internal.build.AllowSysOut;
import pojo.Category;
import pojo.Product;

public class Test2 {

    public static void main(String[] args) {

        // TODO Auto-generated method stub

        Session session = HibernateUtils.getFactory().openSession();
        System.out.println(session);
    }
}