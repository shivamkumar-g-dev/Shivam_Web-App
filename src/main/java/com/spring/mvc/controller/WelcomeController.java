package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@GetMapping("/")
	public String greeting() {
		
		System.out.println("WelcomeController.greeting()");
		return "index";
		

	}
	
	
	@GetMapping("/req-param")
	public String createUser(@RequestParam(name = "user", defaultValue = "MY-DEFAULT-NAME") String name, Model model) {

		model.addAttribute("user", name);

		System.out.println("WelcomeController.greeting :" + name);

		return "success";
	}


	@GetMapping("/path-var/{id}")
	public String pathVarExample(@PathVariable(name = "id") Long id, Model model) {

		model.addAttribute("user", "Sorry this : " + id + " User is not found in our DB");

		System.out.println("WelcomeController.Pathvar : " + id);

		return "success";
	}

}