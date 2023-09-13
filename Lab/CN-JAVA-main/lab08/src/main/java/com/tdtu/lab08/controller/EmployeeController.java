package com.tdtu.lab08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("employees")
public class EmployeeController {
	@GetMapping("/")
	public String gettingList() {
		return "employees/index";
	}
	
	@GetMapping("add")
	public String gettingAddEmp() {
		return "employees/add";
	}
	
	@PostMapping("add")
	public String postingAddEmp(@RequestParam String name, @RequestParam String email, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		return "employees";
	}
	
	@GetMapping("edit")
	public String gettingEditEmp() {
		return "employees/edit/1";
	}
	
//	@PostMapping("edit")
//	public String postingEditEmp(@RequestParam String name, @RequestParam String email, Model model) {
//		model.addAttribute("name", name);
//		model.addAttribute("email", email);
//		return "employees";
//	}
}
