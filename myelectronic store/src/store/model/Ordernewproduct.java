package store.model;

import store.controller.Sellable;
import store.dao.OrdernewproductDAO;

public class Ordernewproduct implements Sellable {
	private int purchaseID;
	private int customerID;
	private String productName;
	private int quantity;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProductName() {
		return productName;
	}
	public int getPurchaseID() {
		return purchaseID;
	}
	public void setPurchaseID(int purchaseID) {
		this.purchaseID = purchaseID;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getproductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	@Override
	public void sellable(Ordernewproduct product) {
		//creating  DAO
				OrdernewproductDAO b = new OrdernewproductDAO();
				b.create(product);
	}
	

}
