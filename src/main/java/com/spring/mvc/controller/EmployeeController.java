package com.spring.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.model.Employee;
import com.spring.mvc.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;


	@GetMapping("/")
	public String welcome() {
		System.out.println("UserController.welcome()");
		return "index";
	}

	@GetMapping("/sign-up")
	public String signUpForm() {
		System.out.println("UserController.signUpForm()");
		return "sign-up";
	}

	@PostMapping("/createUser")
	public String createUser(@ModelAttribute Employee emp, Model model) {
		employeeService.saveEmployee(emp);
		model.addAttribute("employee", emp);
		return "success";
	}

	@GetMapping("/getEmpById/{id}")
	public String getEmp(@PathVariable(name = "id") int id, Model model) {
		
		Employee emp = employeeService.getEmployeeById(id);
		model.addAttribute("employee", emp);
		
		
		return "success";
	}

	
	
	@GetMapping("/employees")
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "employeeList";
	}
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable int id, Model model) {
	    Employee emp = employeeService.getEmployeeById(id);
	    model.addAttribute("employee", emp);
	    return "update"; 
	}
	@PostMapping("/updateEmployee")
	public String updateEmployee(@ModelAttribute Employee emp) {
	    employeeService.saveEmployee(emp);
	    return "redirect:/employees";
	}
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {  
	    employeeService.deleteEmployee(id);
	    return "redirect:/employees";
	}
	
}