package cova.rar.entities;

public class Product {
	
	private int id;
	private String name;
	private String shortDesc;
	private String longDesc;
	private int inventory;
	private String category;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getLongDesc() {
		return longDesc;
	}
	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	
	public void setCategory(String category) {
		this.category = category;
		
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", shortDesc=" + shortDesc + ", longDesc=" + longDesc
				+ ", inventory=" + inventory + ", category=" + category + "]";
	}

}
