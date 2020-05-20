package cova.rar.dao;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import cova.rar.entities.Login;

	public class LoginMapper implements RowMapper<Login>{
	@Override
	public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
		Login login = new Login();
		
		login.setUsername(rs.getString("username"));
		login.setPassword(rs.getString("password"));
		
		return login;
	}
	
}