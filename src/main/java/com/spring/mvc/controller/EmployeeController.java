package com.spring.mvc.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.spring.mvc.model.Employee;

@Controller
public class EmployeeController {

    List<Employee> list = new ArrayList<>();

    public EmployeeController() {
        list.add(new Employee(1, "Shivam", "CS", "Noida"));
        list.add(new Employee(2, "Rahul", "IT", "Delhi"));
        list.add(new Employee(3, "Aman", "HR", "Gurgaon"));
        list.add(new Employee(4, "Avya", "CS", "Noida"));
        list.add(new Employee(5, "Satyam", "IT", "Delhi"));
        list.add(new Employee(6, "Rohit", "HR", "Gurgaon"));
        
    }

    @GetMapping("/getData")
    @ResponseBody
    public String getData() {
        return "Hello This is my first RestApi";
    }

    @GetMapping("/getEmp")
    @ResponseBody
    public Employee getDummyObj() {
        return new Employee(1, "Dummy", "CS", "NOIDA");
    }

    @GetMapping("/")
    public String getEmployees(Model model) {
        model.addAttribute("employees", list);
        return "employeeList";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable int id, Model model) {
        for (Employee e : list) {
            if (e.getId() == id) {
                model.addAttribute("emp", e);
            }
        }
        return "editEmployee";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute Employee emp) {
        for (Employee e : list) {
            if (e.getId() == emp.getId()) {
                e.setUsername(emp.getUsername());
                e.setDepartment(emp.getDepartment());
                e.setAddress(emp.getAddress());
            }
        }
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Iterator<Employee> itr = list.iterator();
        while (itr.hasNext()) {
            Employee e = itr.next();
            if (e.getId() == id) {
                itr.remove();
            }
        }
        return "redirect:/";
    }
}