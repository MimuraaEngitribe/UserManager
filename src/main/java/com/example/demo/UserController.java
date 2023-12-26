package com.example.demo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class UserController {
	
	private final UserService service;
	
	//全件取得
	@GetMapping("/")
	public String getAllUsers(Model model) {
		
		model.addAttribute("page", service.selectAll());
		
		return "list";
	}
	
	@GetMapping("/add")
	public String addUser(@ModelAttribute User user) {
		return "form";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		service.deleteByPrimaryKey(id);
		return "redirect:/";
	}

}