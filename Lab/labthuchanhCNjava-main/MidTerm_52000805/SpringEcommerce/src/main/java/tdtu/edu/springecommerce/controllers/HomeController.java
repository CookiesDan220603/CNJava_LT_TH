package tdtu.edu.springecommerce.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tdtu.edu.springecommerce.models.Product;

import java.util.List;

@Controller
public class HomeController {
    public static final String baseUrl = "http://localhost:8080";
    @GetMapping("/")
    public String goHomePage() {
        return "redirect:/home-page";
    }

    @GetMapping("/home-page")
    public String goHomePage(Model model,HttpServletRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        String api = "/api/product/get-all";
        String url = baseUrl + api;
        List products = restTemplate.getForObject(url,List.class);
        api = "/api/category/get-all";
        url = baseUrl + api;
        Iterable categories = restTemplate.getForObject(url,Iterable.class);

        api = "/api/brand/get-all";
        url = baseUrl + api;
        Iterable brands = restTemplate.getForObject(url,Iterable.class);
        if(model.getAttribute("products")==null){
            model.addAttribute("products", products);
        }
        model.addAttribute("categories", categories);
        model.addAttribute("brands", brands);
        return "index";
    }
    @GetMapping("/home-page/brand/{id}")
    public String getFilterByBrand(@PathVariable("id") Long id, RedirectAttributes ra){
        RestTemplate restTemplate = new RestTemplate();
        String api = "/api/product/find-by-brand-id/"+id;
        String url = baseUrl + api;
        List products = restTemplate.getForObject(url,List.class);
        ra.addFlashAttribute("products",products);
        return "redirect:/home-page";
    }
    @PostMapping("/home-page/filter-price")
    public String getFilterByPrice(@RequestBody String body, RedirectAttributes ra, HttpServletRequest request){
        Double price = Double.valueOf(body.split("=")[1]);
        RestTemplate restTemplate = new RestTemplate();
        String api = "/api/product/find-by-range-price/"+price;
        String url = baseUrl + api;
        List products = restTemplate.getForObject(url,List.class);
        ra.addFlashAttribute("products",products);
        ra.addFlashAttribute("rangePrice",price);
        return "redirect:/home-page";
    }
    @PostMapping("/home-page")
    public String postHomePage() {
        return "index";
    }
    @GetMapping("/contact")
    public String goContact() {
        return "contact-us";
    }

    @GetMapping("/log-out")
    public String goLogout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }
}
