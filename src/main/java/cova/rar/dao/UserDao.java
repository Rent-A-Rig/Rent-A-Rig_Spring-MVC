package cova.rar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import cova.fss.entities.Address;
import cova.rar.entities.Login;
import cova.rar.entities.User;
import cova.rar.service.CookieMonster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public int register(User user) {
		// TODO check if user already exists
		
		//username, password, first name, last name, addressID, email, phone 
		String sql = "insert into user values(?,?,?,?,?,?,?)";
		
		return jdbcTemplate.update(sql, 
				new Object[] {user.getUsername(), user.getPassword(), user.getFirstname(),
						user.getLastname(), user.getAddressID(), user.getEmail(),  user.getPhone()});
	}
	
	public Login validateUser(Login login) {
		String sql = "select * from user where username='" + login.getUsername()
		+ "' and password='" + login.getPassword() + "'";
		
		List<Login> users = jdbcTemplate.query(sql, new LoginMapper());
		System.out.println("size: "+users.size());
		
		if (users.size() > 0) {
			return users.get(0);
		}
		else {
			return null;
		}
	}
	
	public User getUser(String username, HttpServletResponse response) throws SQLException {
		
		String sql = "Select * from user where username = '" + username + "'";
		User user = jdbcTemplate.queryForObject(sql, new UserMapper());
		return user;
		
	}
	
	class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {

			User user = new User();
			
			// no address atm
			user.setUsername(rs.getString("username"));
		    user.setPassword(rs.getString("password"));
		    user.setFirstname(rs.getString("first_name"));
		    user.setLastname(rs.getString("last_name"));
		    user.setAddressID(rs.getString("address_id"));
		    user.setEmail(rs.getString("email"));
		    user.setPhone(rs.getString("phone_number"));

			return user;
		}
		
	}
	
}
