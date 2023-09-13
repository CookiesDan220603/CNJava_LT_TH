package tdtu.edu.springecommerce.services.impservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.springecommerce.models.OrderItem;
import tdtu.edu.springecommerce.services.intservices.OrderItemService;

@Service
public class OrderItemServiceImp {
    @Autowired
    private OrderItemService orderItemService;

    public void save(OrderItem orderItem) {
        orderItemService.save(orderItem);
    }
}
