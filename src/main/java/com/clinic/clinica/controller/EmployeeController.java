package com.clinic.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.clinic.clinica.Service.EmployeeService;
import com.clinic.clinica.modelo.Employees;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employees employees = new Employees();
		model.addAttribute("employee", employees);
		return "new_employee";
	}
	
	
	@PostMapping("/saveEmploy")
	public String saveEmployee(@ModelAttribute("employee") Employees employees) {
	
		employeeService.saveEmployee(employees);
		return "redirect:/";
		
	}
	
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
		
		
	}
	
	
	 @GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		
		Employees employees = employeeService.getEmployeeById(id);
		model.addAttribute("employee", employees);
		return "update_employee";
	}
	 
	 @GetMapping("/deleteEmployee/{id}")
	 public String deleteEmployee(@PathVariable(value = "id") long id) {
		 
		 
		this.employeeService.deleteEmployeeById(id) ;
		return "redirect:/";
		 
		 
		 
		 
		 
		 
	 }

}
