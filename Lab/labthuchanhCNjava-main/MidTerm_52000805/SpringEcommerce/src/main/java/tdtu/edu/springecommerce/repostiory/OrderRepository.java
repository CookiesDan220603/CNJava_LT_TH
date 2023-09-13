package tdtu.edu.springecommerce.repostiory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.springecommerce.models.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long> {
}
