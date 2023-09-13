package tdtu.edu.springecommerce.controllers;

import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tdtu.edu.springecommerce.models.Customer;
import tdtu.edu.springecommerce.models.User;

import java.util.ArrayList;

@Controller
public class CheckOutController {
    public static final String baseUrl = "http://localhost:8080";
    @GetMapping("/check-out")
    public String goCheckOut(HttpServletRequest request, Model model) {
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
        api = "/api/cart/total/" + user.getId();
        url = baseUrl + api;
        restTemplate = new RestTemplate();
        Double total = restTemplate.getForObject(url,Double.TYPE);
        model.addAttribute("carts", carts);
        model.addAttribute("total", total);
        model.addAttribute("user", user);

        api = "/api/customer/find/" + user.getCustomer().getId();
        url = baseUrl + api;
        restTemplate = new RestTemplate();
        String strCustomer = restTemplate.getForObject(url,String.class);
        Gson gson = new Gson();
        Customer customer = gson.fromJson(strCustomer,Customer.class);
        model.addAttribute("customer", customer);
        return "checkout";
    }
    @PostMapping("/check-out/order")
    public String getOrder(Customer customer, RedirectAttributes ra, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("userLogin") == null) {
            return "redirect:/auth";
        }
        User user = (User) session.getAttribute("userLogin");
        String api = "/api/cart/all-by-id/" + user.getId();
        String url = baseUrl + api;
        RestTemplate restTemplate = new RestTemplate();
        String carts = restTemplate.getForObject(url, String.class);
        assert carts != null;
        if (carts.equals("[]")) {
            ra.addFlashAttribute("message","Your cart is empty!");
            return "redirect:/check-out";
        }
        if(customer.containNone()){
            ra.addFlashAttribute("message","Please enter your full information!");
            return "redirect:/check-out";
        }
        //update information customer
        api = "/api/customer/update";
        url = baseUrl +api;
        Gson gson = new Gson();
        String requestJson = gson.toJson(customer);
        restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        restTemplate.postForObject(url, entity, String.class);
        // Add order
        api = "/api/order/add";
        url = baseUrl + api;
        requestJson = "{\"user_id\":\"" + user.getId() + "\",\"customer_id\":\"" + customer.getId() + "\"}";
        headers.setContentType(MediaType.APPLICATION_JSON);
        entity = new HttpEntity<>(requestJson, headers);
        restTemplate.postForObject(url, entity, String.class);
        ra.addFlashAttribute("message","Your order successfully!");
        return "redirect:/check-out";
    }
    @GetMapping("/check-out/order")
    public String getOrder() {
        return "redirect:/check-out";
    }
}
