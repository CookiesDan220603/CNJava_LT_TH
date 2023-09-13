import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@PropertySources({
        @PropertySource("application.properties")
})

public class ConfigApplication  {
    @Value("${id}")
    private Long id;
    @Value("${name}")
    private String name;
    @Value("${description}")
    private String description;
    @Value("${price}")
    private Double price;

    @Bean
    public Product product1() {
        return new Product(id, price, name, description);
    }

    @Bean
    public Product product2() {
        return product1();
    }

    @Bean
    public Product product3() {
        return new Product(3L, 2000.0, "product 3", "description 3");
    }
}