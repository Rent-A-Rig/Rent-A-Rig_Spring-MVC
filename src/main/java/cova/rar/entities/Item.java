package cova.rar.entities;

public class Item {
	
	private Product product;
	private int qty;
	
	
	public boolean equals(Item item) {
		if (item.getProduct().equals(this.product)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}


}
