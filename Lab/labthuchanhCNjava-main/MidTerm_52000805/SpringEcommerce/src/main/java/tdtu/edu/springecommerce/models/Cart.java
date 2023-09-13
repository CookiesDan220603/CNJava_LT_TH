package tdtu.edu.springecommerce.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer quantity;
    private Double price;
    private String image;
    private Long product_id;

    private Double total;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonManagedReference
    @JoinColumn(name = "user_id")
    private User user;

    public Cart(String name,Long product_id, Double price, String image, User user) {
        this.name = name;
        this.price = price;
        this.quantity = 1;
        this.image = image;
        this.user = user;
        this.product_id = product_id;
        this.total = Double.parseDouble(String.format("%.2f", (double)this.price *this.quantity));
    }

    public Cart() {

    }

    public Cart(String name, Long productId, Double price, String image, int quantity, User user) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.user = user;
        this.product_id = productId;
        this.total = Double.parseDouble(String.format("%.2f", (double)this.price *this.quantity));
    }
}
