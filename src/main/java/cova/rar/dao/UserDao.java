package cova.rar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import cova.rar.entities.Login;
import cova.rar.entities.User;

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
		
		//username, first name, last name, shipping, billing, email, phone 
		String sql = "insert into user values(?,?,?,?,?,?,?,?)";
		
		System.out.println(sql);
		return jdbcTemplate.update(sql, 
				new Object[] {user.getUsername(), user.getPassword(), user.getFirstname(),
						user.getLastname(), user.getAddress().toString(),user.getEmail(),  user.getPhone()});
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
	
	class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {

			User user = new User();
			
			// no address atm
			user.setUsername(rs.getString("username"));
		    user.setPassword(rs.getString("password"));
		    user.setFirstname(rs.getString("firstname"));
		    user.setLastname(rs.getString("lastname"));
		    user.setAddress(rs.getString("address"));
		    user.setEmail(rs.getString("email"));
		    user.setPhone(rs.getString("phone"));
		    

			return user;
		}
		/*
		 * class LoginMapper implements RowMapper<Login>{
		 * 
		 * @Override public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
		 * Login login = new Login();
		 * 
		 * login.setUsername(rs.getString("username"));
		 * login.setPassword(rs.getString("password"));
		 * 
		 * return login; }
		 * 
		 * }
		 */
		
		
	}
	
}
