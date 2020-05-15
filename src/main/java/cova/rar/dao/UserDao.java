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
		
		String sql = "insert into users values(?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, 
				new Object[] {user.getUsername(), user.getPassword(), user.getFirstname(),
						user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone()});
	}
	
	public User validateUser(Login login) {
		String sql = "select * from users where username='" + login.getUsername()
		+ "' and password='" + login.getPassword() + "'";
		
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		
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
			
			user.setUsername(rs.getString("username"));
		    user.setPassword(rs.getString("password"));
		    user.setFirstname(rs.getString("firstname"));
		    user.setLastname(rs.getString("lastname"));
		    user.setEmail(rs.getString("email"));
		    user.setAddress(rs.getString("address"));
		    user.setPhone(rs.getInt("phone"));
			
			return user;
		}
		
		
		
	}
	
}
