package store.fashion.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import store.fashion.model.Product;

@Repository
@Component
public interface ProductRepository extends CrudRepository<Product,Integer> {
}
