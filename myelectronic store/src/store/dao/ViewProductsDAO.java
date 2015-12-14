
	package store.dao;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import store.model.Customer;
	import store.model.Ordernewproduct;
import store.model.Products;
	public class ViewProductsDAO {
	private Connection connection;
	private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
	private String username = "fpuser";
	private String password = "510";
	public ArrayList<Products> getProducts(){
	//Get connection
	try {
	connection = DriverManager.getConnection(url, username, password);
	} catch(SQLException e) {
	System.out.println("Error creating connection : " + e);
	System.exit(-1);
	}
	//
	String query = "select p_id,p_name from krishna_product";
	ArrayList<Products> products = new ArrayList<Products>();
	try(PreparedStatement statement = connection.prepareStatement(query)){
	//execute query
	ResultSet resultset = statement.executeQuery();
	while(resultset.next()){
	Products product = new Products();
	product.setProductID(resultset.getInt(1));
	product.setProductName(resultset.getString(2));
	
	products.add(product);
	}
	return products;
	}catch(Exception e){
	System.out.println("Error in loggin"+e);
	return null;
	}
	}
	}
		




