package store.model;

public class Products {
	private int productID;
	private String ProductName;

	public Products() {
	}
	public Products(int productID, String ProductName) {
		this.productID = productID;
		this.ProductName = ProductName;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getproductName() {
		return ProductName;
	}
	public void setProductName(String ProductName) {
		this.ProductName = ProductName;
	}

}
