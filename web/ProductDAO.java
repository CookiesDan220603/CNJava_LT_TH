import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private List<Product> products;

    public ProductDAO() {
        products = new ArrayList<>();
        products.add(new Product("1", "Product 1", 10.0));
        products.add(new Product("2", "Product 2", 20.0));
        products.add(new Product("3", "Product 3", 30.0));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }
}