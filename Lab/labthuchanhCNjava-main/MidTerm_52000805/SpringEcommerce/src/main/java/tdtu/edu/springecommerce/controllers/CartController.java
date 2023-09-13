package tdtu.edu.springecommerce.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import tdtu.edu.springecommerce.models.User;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class CartController {
    public static final String baseUrl = "http://localhost:8080";
    @GetMapping("/cart")
    public String goCart(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("userLogin") == null) {
            return "redirect:/auth";
        }
        User user = (User) session.getAttribute("userLogin");
        String api = "/api/cart/all-by-id/" + user.getId();
        String url = baseUrl + api;
        RestTemplate restTemplate = new RestTemplate();
        Iterable carts = restTemplate.getForObject(url, Iterable.class);
        if (carts == null) {
            carts = new ArrayList<>();
        }
        model.addAttribute("carts", carts);
        model.addAttribute("user", user);
        return "cart";
    }
    @PostMapping("/cart/add")
    public String postAddToCart(@RequestBody Map<String,String> body, HttpServletRequest request){
        HttpSession session = request.getSession();
        if (session.getAttribute("userLogin") == null) {
            return "redirect:/auth";
        }
        User user = (User) session.getAttribute("userLogin");
        int quantity = Integer.parseInt(body.get("quantity"));
        long product_id = Long.parseLong(body.get("product_id"));
        String api = "/api/cart/add";
        String url = baseUrl + api;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String requestJson = "{\"user_id\":\"" + user.getId() + "\",\"product_id\":\"" + product_id + "\",\"quantity\":\"" + quantity + "\"}";
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        restTemplate.postForObject(url, entity, String.class);
        return "redirect:/cart";
    }

    @GetMapping("/cart/add/{id}")
    public String addToCart(@PathVariable("id") Long product_id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("userLogin") == null) {
            return "redirect:/auth";
        }
        User user = (User) session.getAttribute("userLogin");
        String api = "/api/cart/add";
        String url = baseUrl + api;
        int quantity = 0;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String requestJson = "{\"user_id\":\"" + user.getId() + "\",\"product_id\":\"" + product_id + "\",\"quantity\":\"" + quantity + "\"}";
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        restTemplate.postForObject(url, entity, String.class);
        return "redirect:/cart";
    }

    @GetMapping("/cart/delete/{id}")
    public String removeToCart(@PathVariable("id") Long id) {
        String api = "/api/cart/delete/"+id;
        String url = baseUrl + api;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(url);
        return "redirect:/cart";
    }
}
