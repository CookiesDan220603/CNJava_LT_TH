package tdtu.edu.lab09_10.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch =FetchType.EAGER)
    @JsonManagedReference
    private Product product;
    @ManyToOne(fetch =FetchType.EAGER)
    @JsonManagedReference
    private Account account;
    private Integer quantity;
}
