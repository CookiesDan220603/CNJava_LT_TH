package tdtu.edu.springecommerce.services.intservices;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tdtu.edu.springecommerce.models.Product;
import tdtu.edu.springecommerce.repostiory.ProductRepository;

@Service
public interface ProductService extends ProductRepository {
    @Query(value = "FROM Product AS p WHERE p.name LIKE %:text% OR p.category.name like %:text% " +
            "OR p.brand.name like %:text% ORDER BY p.price DESC")
    Iterable<Product> searchAdvance(String text);
    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.quantity = p.quantity - :quan WHERE p.id =:id")
    void updateQuantity(Long id, int quan);
    @Query(value = "FROM Product AS p WHERE p.brand.id=:brandId")
    Iterable<Product> findAllProByBrandId(Long brandId);
    @Query(value = "FROM Product AS p WHERE p.price<=:price")
    Iterable<Product> findAllByLessRange(Double price);

}
