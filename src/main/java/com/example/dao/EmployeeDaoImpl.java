package com.example.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
 private JdbcTemplate jdbcTemplate;

 public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
     this.jdbcTemplate = jdbcTemplate;
 }

 @Override
 public List<Employee> getAllEmployees() {
     String sql = "SELECT * FROM employee";
     return jdbcTemplate.query(sql, new EmployeeRowMapper());
 }

 @Override
 public Employee getEmployeeById(Long id) {
     String sql = "SELECT * FROM employee WHERE id = ?";
     return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
 }

 @Override
 public void addEmployee(Employee employee) {
     String sql = "INSERT INTO employee (first_name, last_name, age) VALUES (?, ?, ?)";
     jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getAge());
 }

 @Override
 public void deleteEmployee(Long id) {
     String sql = "DELETE FROM employee WHERE id = ?";
     jdbcTemplate.update(sql, id);
 }

 // RowMapper implementation to convert ResultSet to Employee objects
 private static class EmployeeRowMapper implements RowMapper<Employee> {
     @Override
     public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
         Employee employee = new Employee();
         employee.setId(rs.getLong("id"));
         employee.setFirstName(rs.getString("first_name"));
         employee.setLastName(rs.getString("last_name"));
         employee.setAge(rs.getInt("age"));
         return employee;
     }
 }
}
