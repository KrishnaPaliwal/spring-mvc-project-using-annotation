package com.example.dao;

import java.util.List;

import com.example.model.Employee;

public interface EmployeeDao {
 List<Employee> getAllEmployees();
 Employee getEmployeeById(Long id);
 void addEmployee(Employee employee);
 void deleteEmployee(Long id);
}
