package store.springcommerce.repository;


import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import store.springcommerce.model.Product;

import java.util.List;

@Repository
@Component
//@EnableJdbcRepositories
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
