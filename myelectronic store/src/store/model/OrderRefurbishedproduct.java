package store.model;

public class OrderRefurbishedproduct {
	private int rentID;
	private int customerID;
	private String productName;
	private int rentDay;

	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public int getRentID() {
		return rentID;
	}
	public void setRentID(int rentID) {
		this.rentID = rentID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getRentDay() {
		return rentDay;
	}
	public void setRentDay(int rentDay) {
		this.rentDay = rentDay;
	}

}
