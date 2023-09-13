package tdtu.edu.lab09_10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tdtu.edu.lab09_10.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
