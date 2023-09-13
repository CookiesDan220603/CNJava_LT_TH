package tdtu.edu.lab09_10.service;

import tdtu.edu.lab09_10.model.Product;

public interface ProductService{
    Product save(Product products);
    Product update(Product products);
    void delete(Long product_id);
    Iterable<Product> findAll();
    Product findById(Long id);
}
