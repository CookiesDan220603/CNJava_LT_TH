package tdtu.edu.springecommerce.controllers;

import com.google.gson.Gson;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
import tdtu.edu.springecommerce.models.User;

@Controller
public class AuthController {
    public static final String baseUrl = "http://localhost:8080";
    @GetMapping("/auth")
    public String goAuth(Model model, HttpServletRequest request, RedirectAttributes ra) {
        HttpSession session = request.getSession();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    model.addAttribute("remUsername", cookie.getValue());
                }
                if (cookie.getName().equals("password")) {
                    model.addAttribute("remPassword", cookie.getValue());
                }
            }
        }
        if (session.getAttribute("userLogin") != null) {
            ra.addFlashAttribute("message", "Login success!");
            return "redirect:/";
        }
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/auth/login")
    public String goLogin(User user, RedirectAttributes ra, HttpServletRequest request, HttpServletResponse response) {
        String api = "/api/auth/login/user-valid";
        String url = baseUrl + api;
        String requestJson = "{\"username\":\"" + user.getUsername() + "\",\"password\":\"" + user.getPassword() + "\"}";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        String strUser = restTemplate.postForObject(url, entity, String.class);
        Gson gson = new Gson();
        User userValid = gson.fromJson(strUser, User.class);
        if (userValid != null) {
            HttpSession session = request.getSession();
            Cookie ck = new Cookie("username", user.getUsername());
            Cookie ck1 = new Cookie("password", user.getPassword());
            response.addCookie(ck);
            response.addCookie(ck1);
            session.setAttribute("userLogin", userValid);
        } else ra.addFlashAttribute("message", "Password or Username invalid!");
        return "redirect:/auth";
    }

    @GetMapping("/auth/login")
    public String goLogin() {
        return "redirect:/auth";
    }

    @GetMapping("/auth/signup")
    public String goSignUp() {
        return "redirect:/auth";
    }

    @PostMapping("/auth/signup")
    public String goSignUp(User user, RedirectAttributes ra) {
        String api = "/api/user/add";
        String url = baseUrl + api;
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        Gson gson = new Gson();
        String requestJson = gson.toJson(user);
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);
        String strMessage = restTemplate.postForObject(url, entity, String.class);
        ra.addFlashAttribute("messageRegister", strMessage);
        return "redirect:/auth";
    }

}
