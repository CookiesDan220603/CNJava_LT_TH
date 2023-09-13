package tdtu.edu.lab09_10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.lab09_10.model.Product;
import tdtu.edu.lab09_10.repository.ProductRepository;
@Service
public class ProductServiceImp implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product save(Product products) {
        return productRepository.save(products);
    }

    @Override
    public Product update(Product products) {
        return productRepository.save(products);
    }

    @Override
    public void delete(Long product_id) {
        productRepository.deleteById(product_id);
    }

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        if( productRepository.findById(id).isPresent()){
            return productRepository.findById(id).get();
        }
        return null;
    }
}
