package com.tdtu.lab08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
//	@RequestMapping(value = "/", method = RequestMethod.GET)
	@GetMapping("/")
	public String gettingIndex() {
		return "index";
	}
	
//	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	@GetMapping("/contact")
	public String gettingContact() {
		return "contact";
	}
	
//	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	@PostMapping("/contact")
	public String postingContact(
			// 1. Lay tham so truyen tu contact
			@RequestParam String name, 
			@RequestParam String email, 
			Model model) {
		System.out.println(name + "\n" + email);
		// 2. Hien thi tham so trong contact2
		model.addAttribute("name", name);
        model.addAttribute("email", email);
		return "edit";
	}
	
//	@RequestMapping(value = "/about", method = RequestMethod.GET)
	@GetMapping("/about")
	public String gettingAbout() {
		return "about";
	}
}