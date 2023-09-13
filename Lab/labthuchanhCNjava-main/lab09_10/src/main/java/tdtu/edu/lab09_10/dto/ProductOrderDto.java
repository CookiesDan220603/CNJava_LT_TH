package tdtu.edu.lab09_10.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tdtu.edu.lab09_10.model.Account;
import tdtu.edu.lab09_10.model.Product;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ProductOrderDto {
    private Long id;
    private Product product;
    private Account account;
    private Integer quantity;
}
