package cova.rar.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cova.rar.entities.Product;

public class ProductDao {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public List<Product> getAll() {
		String sql = "select * from products";
		
		List<Product> products = jdbcTemplate.query(sql, new ProductMapper());
		
		return products;
	}

	public List<Product> getSearch(String filter) {
		// TODO get all products where prodName contains filter string
		return null;
	}
	
	class ProductMapper implements RowMapper<Product> {

		@Override
		public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Product product = new Product();
			
			product.setId(rs.getInt("prodID"));
			product.setName(rs.getString("prodName"));
			product.setShortDesc(rs.getString("shortDesc"));
			product.setLongDesc(rs.getString("longDesc"));
			product.setInventory(rs.getInt("inventory"));
			
			return product;
		}
		
	}
	
	
	
}
