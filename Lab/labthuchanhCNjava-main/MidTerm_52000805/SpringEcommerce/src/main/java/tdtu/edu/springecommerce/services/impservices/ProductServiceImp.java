package tdtu.edu.springecommerce.services.impservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.springecommerce.models.Product;
import tdtu.edu.springecommerce.services.intservices.ProductService;
@Service
public class ProductServiceImp {
    @Autowired
    private ProductService productService;

    public Iterable<Product> findAll() {
        return productService.findAll();
    }
    public Iterable<Product> searchAdvance(String text){
        return productService.searchAdvance(text);
    }
    public void updateQuantity(Long id,int quan){
        productService.updateQuantity(id,quan);
    }

    public Product findByID(Long id) {
        if(productService.findById(id).isPresent())
            return productService.findById(id).get();
        else
            return null;
    }

    public Iterable<Product> findAllProdByBrandId(Long brandId) {
        return productService.findAllProByBrandId(brandId);
    }

    public Iterable<Product> findAllByLessPrice(Double price) {
        return productService.findAllByLessRange(price);

    }
}
