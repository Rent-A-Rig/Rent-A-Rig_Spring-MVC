package cova.rar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cova.rar.dao.ProductDao;
import cova.rar.entities.Product;

public class ProductService {
	
	@Autowired
	ProductDao productDao;
	
	public List<Product> getProducts(String filter) {
		List<Product> products = null;
		
		switch(filter) {
			case "all": return productDao.getAll();
			default: return productDao.getSearch(filter);
		}

	}

}
