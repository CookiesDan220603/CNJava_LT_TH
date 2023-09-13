package tdtu.edu.lab09_10.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long code;
    private String productName;
    private Double price;
    private String illustration;
    private String description;
    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
    @JsonBackReference
    private List<ProductOrder> productOrders;
    @Builder
    public Product(Long code, String productName, Double price, String illustration, String description) {
        this.code = code;
        this.productName = productName;
        this.price = price;
        this.illustration = illustration;
        this.description = description;
    }
}
