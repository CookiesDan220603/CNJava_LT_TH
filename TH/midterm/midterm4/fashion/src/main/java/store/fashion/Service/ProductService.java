package store.fashion.Service;

import org.springframework.beans.factory.annotation.Autowired;
import store.fashion.model.Product;
import store.fashion.repository.ProductRepository;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
    void saveProduct(Product product);
    void deleteProduct(int id);
}
