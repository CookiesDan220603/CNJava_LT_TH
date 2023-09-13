package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ProductBean {
    @Bean
    @Scope("prototype")
    public Product product1()
    {
        Product product = new Product();
        product.setName("san pham 1");
        product.setId(1);
        product.setDescription("qua da");
        product.setPrice(24444);
        return product;
    }
    @Bean
    @Scope("prototype")
    public Product product2()
    {
        return new Product(product1());
    }
    @Bean
    public Product product3()
    {
        return new Product(3,"san pham 3","tuyet voi qua",129999);
    }
}