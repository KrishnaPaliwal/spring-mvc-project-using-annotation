package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
//EmployeeController.java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.dao.EmployeeDao;
import com.example.model.Employee;

import java.util.List;

@Controller
public class EmployeeController {
	
 private EmployeeDao employeeDao;

 @Autowired
 public EmployeeController(EmployeeDao employeeDao) {
     this.employeeDao = employeeDao;
 }

 @GetMapping("/")
 public String showAllEmployees(Model model) {
     List<Employee> employees = employeeDao.getAllEmployees();
     model.addAttribute("employees", employees);
     return "employee-list";
 }

 @GetMapping("/add")
 public String showAddEmployeeForm(Model model) {
     model.addAttribute("employee", new Employee());
     return "employee-form";
 }

 @PostMapping("/add")
 public String addEmployee(@ModelAttribute Employee employee) {
     employeeDao.addEmployee(employee);
     return "redirect:/";
 }

 @GetMapping("/delete/{id}")
 public String deleteEmployee(@PathVariable Long id) {
     employeeDao.deleteEmployee(id);
     return "redirect:/";
 }
}

