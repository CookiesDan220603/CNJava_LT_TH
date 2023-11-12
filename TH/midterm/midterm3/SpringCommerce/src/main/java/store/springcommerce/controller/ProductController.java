package store.springcommerce.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import store.springcommerce.model.Product;
import store.springcommerce.service.ProductService;

import java.util.List;



@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String listProducts(Model theModel){
        List <Product> theProduct = productService.getAllProducts();
        theModel.addAttribute("product",theProduct);
        return "list-product";
    }
    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        Product theProduct = new Product();
        theModel.addAttribute("product", theProduct);
        return "product-form";
    }
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product theProduct) {
        productService.saveProduct(theProduct);
        return "redirect:/products/list";
    }
    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("productID") int theId,
                                    Model theModel) {
        Product theProduct = productService.getProductById(theId);
        theModel.addAttribute("product", theProduct);
        return "product-form";
    }
    @GetMapping("/delete")
    public String deleteProduct(@RequestParam("productID") int theId) {
        productService.deleteProduct(theId);
        return "redirect:/products/list";
    }

}