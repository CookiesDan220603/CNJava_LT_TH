package store.springcommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.springcommerce.model.Product;
import store.springcommerce.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl extends ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

//    @Override
//    public List<Product> searchProducts(String keyword) {
//        // Implement product search based on the keyword
//        return productRepository.searchProducts(keyword);
//    }

    // Other methods specific to ProductService can be implemented here

}