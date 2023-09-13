package tdtu.edu.springecommerce.services.impservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import tdtu.edu.springecommerce.models.Cart;
import tdtu.edu.springecommerce.models.Product;
import tdtu.edu.springecommerce.services.intservices.BrandService;
import tdtu.edu.springecommerce.services.intservices.CartService;

import java.util.Collections;

@Service
public class CartServiceImp {
    @Autowired
    private CartService cartService;
    public Cart save(Cart cart){
        return cartService.save(cart);
    }

    public Iterable<Cart> findAllByUserID(Long id) {
        return cartService.findAllByUserId(id);
    }
    public boolean checkProductExist(Long user_id,Long product_id) {
        return cartService.findProduct(user_id,product_id)!=null;
    }

    public void deleteByID(Long id) {
        cartService.deleteById(id);
    }
    public boolean checkByID(Long id){
        return cartService.findById(id).isPresent();
    }

    public void updateQuantity(Long userId,Long productId) {
        cartService.updateQuantity(userId,productId);
    }
    public void updateQuantity(Long userId,Long productId,int quantity) {
        cartService.updateQuantity(userId,productId,quantity);
    }
    public Cart findByUserIdAndProdId(Long userId,Long productId) {
        return cartService.findByUserIdAndProductId(userId,productId);
    }

    public Double totalCartByUserId(Long userId) {
        return cartService.totalCartBy(userId);
    }
}
