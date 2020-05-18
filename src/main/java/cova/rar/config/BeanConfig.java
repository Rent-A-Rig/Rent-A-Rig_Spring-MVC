package cova.rar.config;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import cova.rar.dao.UserDao;
import cova.rar.service.UserService;

@Configuration
@ComponentScan(basePackages = {"cova.rar",
		"org.springframework.jdbc.datasource.DriverManagerDataSource",
		"org.springframework.jdbc.core.JdbcTemplate"})
public class BeanConfig {
	
	@Bean
	public UserService userService() {
		return new UserService();
	}
	
	@Bean 
	public UserDao userDao() {
		return new UserDao();
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dmds = 
				new DriverManagerDataSource("jdbc:mysql://localhost:3306/RentARig", "root", "root");
		dmds.setDriverClassName("com.mysql.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost/rentarig?useSSL=false");
		dmds.setUsername("root");
		dmds.setPassword("root");
		dmds.setSchema("rentarig");
		return dmds;
	}
	
	@Bean 
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
	
	
	

}
