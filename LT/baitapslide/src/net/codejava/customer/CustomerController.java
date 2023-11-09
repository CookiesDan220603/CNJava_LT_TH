package net.codejava.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping("/")
    public ModelAndView home() {
        List<Customer> listCustomer = customerService.listAll();
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("listCustomer", listCustomer);
        return mav;
    }

}
