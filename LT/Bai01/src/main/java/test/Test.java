package test;

//import java.math.BigDecimal;
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
import pojo.Category;
import pojo.Product;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session=HibernateUtils.getFactory().openSession();
		
//Them		
//		Category c= new Category();//transient
//		c.setName("May In");
//		c.setDescripttion("Chi tiết cấu hình ");
//      session.save(c);
//Update		
//		Category c=session.get(Category.class, 1); //persistent lấy lên
//		c.setDescripttion("Dữ liệu mới cập nhât");
//		
//		session.getTransaction().begin();//Tranh chấp ghi dữ liệu phải có GIAO TAC (bật tuong tac có 2 client cùng thực hiện)
//		session.save(c);
//		session.getTransaction().commit();

//Delete		
//		Category c=session.get(Category.class, 1); //persistent lấy lên
//		
//		session.getTransaction().begin();//Tranh chấp ghi dữ liệu phải có GIAO TAC (bật tuong tac có 2 client cùng thực hiện)
//		session.delete(c);
//		session.getTransaction().commit();
		
//Truy vấn HQL All
//		Query q=session.createQuery("FROM Category"); //HQL of Class
//		List<Category> cates=q.getResultList();
//		cates.forEach(c->System.out.printf("%d - %s \n", c.getId(), c.getName()));

//Truy vấn HQL Id
//		Query q=session.createQuery("FROM Category WHERE id=5"); //HQL of Class
//		List<Category> cates=q.getResultList();
//		cates.forEach(c->System.out.printf("%d - %s \n", c.getId(), c.getName()));

		
//Add Prodect
//		Product p=new Product();
//		p.setName("Ipad Pro 2023");
//		p.setPrice(new BigDecimal(300000000));
//		Category c=session.get(Category.class, 9);
//		p.setCategory(c);
//		
//		session.save(p);
		
//Prodect for id ( Test @ManyToOne(fetch = FetchType.LAZY))
//		Product p=session.get(Product.class, 2);
//		System.out.println(p.getName());

//Truy vấn for id test @OneToMany(mappedBy = "category", fetch= FetchType.EAGER).
//		Category c=session.get(Category.class, 9); //persistent lấy lên
//		c.getProducts().forEach(p->System.out.printf("%d - %s \n", p.getId(), p.getName()));		
		
//
		CriteriaBuilder builder =session.getCriteriaBuilder();
		CriteriaQuery<Product> query =builder.createQuery(Product.class);
		Root root =query.from(Product.class);
		
		query =query.select(root);
		
		//add condition ngoài like rất n thứ khác
		Predicate p1 =builder.like(root.get("name").as(String.class), "%Pro%");
		query=query.where(p1);
		
		Query q=session.createQuery(query);
		
		List<Product> products=q.getResultList();
		products.forEach(p->System.out.printf("%d - %s \n", p.getId(), p.getName()));
//		
//Ket qua n phan tu n class
//		List<Object[]> kq=q.getResultList();
//		kq.forEach(k->{
//			System.out.printf("%s - count: %d  - Max: %.2f\n", k[0], k[1], k[2]);
//		});
		session.close();
	}

}
