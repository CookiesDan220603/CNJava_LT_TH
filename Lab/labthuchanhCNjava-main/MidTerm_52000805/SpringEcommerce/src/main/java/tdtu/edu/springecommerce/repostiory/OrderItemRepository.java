package tdtu.edu.springecommerce.repostiory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.springecommerce.models.OrderItem;
@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem,Long> {
}
