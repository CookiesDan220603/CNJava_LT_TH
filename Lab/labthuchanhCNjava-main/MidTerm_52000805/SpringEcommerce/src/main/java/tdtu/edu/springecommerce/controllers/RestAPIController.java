package tdtu.edu.springecommerce.controllers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tdtu.edu.springecommerce.models.*;
import tdtu.edu.springecommerce.services.impservices.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
public class RestAPIController {
    @Autowired
    private ProductServiceImp productServiceImp;
    @Autowired
    private CategoryServiceImp categoryServiceImp;
    @Autowired
    private UserServiceImp userServiceImp;
    @Autowired
    private CustomerServiceImp customerServiceImp;
    @Autowired
    private CartServiceImp cartServiceImp;
    @Autowired
    private OrderServiceImp orderServiceImp;
    @Autowired
    private OrderItemServiceImp orderItemServiceImp;
    @Autowired
    private BrandServiceImp brandServiceImp;
    @GetMapping("/api/brand/get-all")
    public Iterable<Brand> getAllBrand(){
        return brandServiceImp.findAll();
    }
    @GetMapping("/api/category/get-all")
    public Iterable<Category> getAllCategory(){
        return categoryServiceImp.findAll();
    }
    @GetMapping("/api/product/get-all")
    public Iterable<Product> getAllProduct(){
        return productServiceImp.findAll();
    }
    @GetMapping("/api/product/find/{id}")
    public Product getDetails(@PathVariable("id") Long id) {
        return productServiceImp.findByID(id);
    }
    @GetMapping("/api/product/search/{id}")
    public Iterable<Product> getSearchAdvanced(@PathVariable("id")String text) {
        return productServiceImp.searchAdvance(text);
    }
    @GetMapping("/api/product/find-by-brand-id/{id}")
    public Iterable<Product> getAllProdByBrandId(@PathVariable("id")Long brand_id) {
        return productServiceImp.findAllProdByBrandId(brand_id);
    }
    @GetMapping("/api/product/find-by-range-price/{id}")
    public Iterable<Product> getAllProdByRangePrice(@PathVariable("id")Double price) {
        return productServiceImp.findAllByLessPrice(price);
    }
    @PostMapping("/api/cart/add")
    public Cart addCart(@RequestBody Map<String, Long> body) {
        Long user_id = body.get("user_id");
        Long product_id = body.get("product_id");
        int quantity = Integer.parseInt(body.get("quantity").toString());
        if(quantity==0){
            if(cartServiceImp.checkProductExist(user_id,product_id)){
                cartServiceImp.updateQuantity(user_id,product_id);
                return cartServiceImp.findByUserIdAndProdId(user_id,product_id);
            }
            User user = userServiceImp.findById(user_id);
            Product product = productServiceImp.findByID(product_id);
            Cart cart = new Cart(product.getName(),product_id,product.getPrice(),product.getImage(),user);
            return cartServiceImp.save(cart);
        }
        else {
            if(cartServiceImp.checkProductExist(user_id,product_id)) {
                cartServiceImp.updateQuantity(user_id,product_id,quantity);
                return cartServiceImp.findByUserIdAndProdId(user_id,product_id);
            }
        }
        User user = userServiceImp.findById(user_id);
        Product product = productServiceImp.findByID(product_id);
        Cart cart = new Cart(product.getName(),product_id,product.getPrice(),product.getImage(),quantity,user);
        return cartServiceImp.save(cart);
    }
    @GetMapping("/api/cart/all-by-id/{id}")
    public Iterable<Cart> getCartByUserID(@PathVariable("id") Long user_id){
        return cartServiceImp.findAllByUserID(user_id);
    }
    @GetMapping("/api/cart/total/{id}")
    public Double totalCartByUserId(@PathVariable("id") Long user_id){
        return cartServiceImp.totalCartByUserId(user_id);
    }
    @DeleteMapping("/api/cart/delete/{id}")
    public boolean removeCartByID(@PathVariable("id") Long id){
        if(cartServiceImp.checkByID(id)){
            cartServiceImp.deleteByID(id);
            return true;
        }
        return false;
    }
    @GetMapping("/api/customer/find/{id}")
    public Customer getByID(@PathVariable("id") Long id){
        return customerServiceImp.findById(id);
    }
    @PostMapping("/api/customer/update")
    public Customer postUpdateCus(@RequestBody Map<String,String> body){
        Long customer_id = Long.parseLong(body.get("id"));
        Customer customer = customerServiceImp.findById(customer_id);
        String name = body.get("name");
        String phone = body.get("phone");
        String address = body.get("address");
        String email = body.get("email");
        customer.setAddress(address);
        customer.setName(name);
        customer.setPhone(phone);
        customer.setEmail(email);
        return customerServiceImp.save(customer);
    }
    @PostMapping("/api/order/add")
    public Order getAddOrder(@RequestBody Map<String,Long> body){
        Customer customer = customerServiceImp.findById(body.get("customer_id"));
        Double total = cartServiceImp.totalCartByUserId(body.get("user_id"));
        Iterable<Cart> carts = cartServiceImp.findAllByUserID(body.get("user_id"));
        Order order = new Order();
        LocalDateTime now = LocalDateTime.now();
        order.setDate(now);
        order.setCustomer(customer);
        order.setTotal(total);
        order = orderServiceImp.save(order);
        for(Cart cart:carts){
            Product product = productServiceImp.findByID(cart.getProduct_id());
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setPrice(product.getPrice());
            orderItem.setQuantity(cart.getQuantity());
            orderItemServiceImp.save(orderItem);
            productServiceImp.updateQuantity(product.getId(),cart.getQuantity());
            cartServiceImp.deleteByID(cart.getId());
        }
        return orderServiceImp.save(order);
    }

    @PostMapping("/api/auth/login/user-valid")
    public User getValidUser(@RequestBody Map<String,String> body){
        String username = body.get("username");
        String password = body.get("password");
        return userServiceImp.userLoginValid(username,password);
    }
    @PostMapping("/api/user/add")
    public String addUser(@RequestBody String request){
        Gson gson = new Gson();
        User user = gson.fromJson(request,User.class);
        if(userServiceImp.checkUserExist(user.getUsername())){
            return "Username is exist!";
        }
        String rePassword = user.getCustomer().getName();
        if(!rePassword.equals(user.getPassword())){
            return "Again password wrong!";
        }
        // Remove rePassword in name of customer
        user.getCustomer().setName(null);
        //Add Customer
        Customer customer = customerServiceImp.save(user.getCustomer());
        // Add User
        user.setCustomer(customer);
        userServiceImp.save(user);
        return "Sign up success!";
    }
}
