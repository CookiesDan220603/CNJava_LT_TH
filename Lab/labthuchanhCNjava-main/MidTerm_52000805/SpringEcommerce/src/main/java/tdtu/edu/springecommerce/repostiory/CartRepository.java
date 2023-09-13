package tdtu.edu.springecommerce.repostiory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.springecommerce.models.Cart;
import tdtu.edu.springecommerce.models.Category;

@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {
}
