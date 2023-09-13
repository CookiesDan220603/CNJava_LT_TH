package tdtu.edu.lab09_10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tdtu.edu.lab09_10.dto.ProductDto;
import tdtu.edu.lab09_10.model.Product;
import tdtu.edu.lab09_10.service.ProductServiceImp;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductServiceImp productServiceImp;
    @GetMapping("/")
    public Iterable<Product> productList(){
        return productServiceImp.findAll();
    }

    @PostMapping("/")
    public ResponseEntity<Product> AddProduct(@RequestBody ProductDto productDto){
        Product product = Product.builder().productName(productDto.getProductName())
                .price(productDto.getPrice()).illustration(productDto.getIllustration())
                .description(productDto.getDescription()).build();
        Product productSaved = productServiceImp.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
    }
    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id){
        return productServiceImp.findById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProdById(@PathVariable("id") Long id, @RequestBody ProductDto productDto){
        Product product = Product.builder().code(id).price(productDto.getPrice()).productName(productDto.getProductName())
                .description(productDto.getDescription())
                .illustration(productDto.getIllustration()).build();
        if(productServiceImp.findById(id)==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Product());
        }
        Product productSaved = productServiceImp.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> patchProdById(@PathVariable("id") Long id, @RequestBody ProductDto productDto){
        Product product = Product.builder().code(id).price(productDto.getPrice()).productName(productDto.getProductName())
                .description(productDto.getDescription())
                .illustration(productDto.getIllustration()).build();
        if(productServiceImp.findById(id)==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Product());
        }
        Product productSaved = productServiceImp.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productSaved);
    }
    @DeleteMapping("/{id}")
    public String delProdById(@PathVariable("id") Long id){
        Product product = productServiceImp.findById(id);
        if(product==null){
            return "delete fail";
        }
        else{
            productServiceImp.delete(id);
            return "delete success";
        }
    }
}
