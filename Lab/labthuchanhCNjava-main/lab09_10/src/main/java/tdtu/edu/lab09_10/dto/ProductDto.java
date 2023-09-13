package tdtu.edu.lab09_10.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class ProductDto {
    private Long code;
    private String productName;
    private Double price;
    private String illustration;
    private String description;
    @Builder
    public ProductDto(Long code, String productName, Double price, String illustration, String description) {
        this.code = code;
        this.productName = productName;
        this.price = price;
        this.illustration = illustration;
        this.description = description;
    }
}
