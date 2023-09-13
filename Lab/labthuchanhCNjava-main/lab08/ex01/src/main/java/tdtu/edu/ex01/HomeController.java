package tdtu.edu.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String goHomePage(){
        return "index";
    }
    @GetMapping("/contact")
    public String getContact(){
        return "contact";
    }
    @PostMapping("/contact")
    public String postContact(@RequestParam String name, @RequestParam String email, Model model){
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        return "information";
    }

    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }
    @PostMapping("/about")
    public String postAbout(){
        return "about";
    }
}
