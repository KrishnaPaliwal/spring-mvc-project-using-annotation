package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.dao.EmployeeDao;
import com.example.dao.EmployeeDaoImpl;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.example")
@EnableWebMvc
public class ApplicationConfig implements WebMvcConfigurer {

 @Autowired
 private Environment env;

 @Override
 public void configureViewResolvers(ViewResolverRegistry registry) {
     registry.jsp("/WEB-INF/views/", ".jsp");
 }

 static {
	 System.out.println("Configured");
 }
 @Bean
 public DataSource dataSource() {
     DriverManagerDataSource dataSource = new DriverManagerDataSource();
     dataSource.setDriverClassName(env.getProperty("db.driverClassName"));
     dataSource.setUrl(env.getProperty("db.url"));
     dataSource.setUsername(env.getProperty("db.username"));
     dataSource.setPassword(env.getProperty("db.password"));
     return dataSource;
 }

 @Bean
 public JdbcTemplate jdbcTemplate(DataSource dataSource) {
     return new JdbcTemplate(dataSource);
 }

 @Bean
 public EmployeeDao employeeDao(JdbcTemplate jdbcTemplate) {
     return new EmployeeDaoImpl(jdbcTemplate);
 }
}
