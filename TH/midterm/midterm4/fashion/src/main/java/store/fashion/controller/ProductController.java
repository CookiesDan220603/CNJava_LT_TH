package store.fashion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import store.fashion.Service.ProductService;
import store.fashion.model.Product;

import java.util.List;
@Controller
//@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView homePage(){
        return new ModelAndView("list-product");
    }
//    @GetMapping("/list")
//    public String listProducts(Model theModel) {
//        List<Product> theProducts = productService.getAllProducts();
//        theModel.addAttribute("products", theProducts);
//        return "list-product";
//    }
//    @GetMapping("/showForm")
//    public String showFormForAdd(Model theModel) {
//        Product theProduct = new Product();
//        theModel.addAttribute("product", theProduct);
//        return "product-form";
//    }
}
