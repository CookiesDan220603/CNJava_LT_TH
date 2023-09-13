import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    public Long id;
    public Double price;
    public String name, description;

    public Product(Product other) {
        this.id = other.id;
        this.price = other.price;
        this.name = other.name;
        this.description = other.description;
    }
}
