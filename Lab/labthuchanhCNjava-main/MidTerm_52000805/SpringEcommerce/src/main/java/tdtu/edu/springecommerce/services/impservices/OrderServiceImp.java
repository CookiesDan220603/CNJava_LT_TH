package tdtu.edu.springecommerce.services.impservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.springecommerce.models.Order;
import tdtu.edu.springecommerce.services.intservices.OrderService;

@Service
public class OrderServiceImp {
    @Autowired
    private OrderService orderService;

    public Order save(Order order) {
        return orderService.save(order);
    }
}
