package cova.rar.entities;

import java.sql.Date;
import java.util.List;


public class Order {
	
	private Date date;
	private List<Item> items;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}

	
	

}
