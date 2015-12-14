package store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import store.model.Products;

public class ProductDAO {
		private Connection connection;
		//Database connection parameters
	    private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
	    private String username = "fpuser";
	    private String password = "510";

	    public ArrayList<String>udetails(){
	    	//Get connection
	    	try {
	            connection = DriverManager.getConnection(url, username, password);
	        } catch(SQLException e) {
	            System.out.println("Error creating connection : " + e);
	            System.exit(-1);
	        }
	        	String query = "select Distinct(p_id) from krishna_product";
	        	ArrayList<String>product_list = new ArrayList<String>();
	        	try(PreparedStatement statement = connection.prepareStatement(query)){
	        		ResultSet resultset = statement.executeQuery();
	        		while(resultset.next()){
	        			product_list.add(resultset.getString(1));
	        		}
	        		return product_list;
	        	}catch(Exception e){
	        	System.out.println("Error in loggin"+e);
	        	return null;
	        }
	    }


	    public Products addProduct(Products products){
	    			try {
	    	            connection = DriverManager.getConnection(url, username, password);
	    	        } catch(SQLException e) {
	    	            System.out.println("Error creating connection to database: " + e);
	    	            System.exit(-1);
	    	        }
	    			//Query to insert a record to the product table
	    	String query="INSERT INTO krishna_product (p_id, p_name) VALUES (?, ?)";
	    	try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
	    		//Set the parameters
	    		statement.setInt(1, products.getProductID());
	            statement.setString(2, products.getproductName());
	            statement.executeUpdate();
	            System.out.println("Products Added");
	            ResultSet resultSet = statement.getGeneratedKeys();
	            if(resultSet.next()) {
	            	//Set the id field of  database to the model
	            	products.setProductID(resultSet.getInt(1));
	            }
	        } catch(SQLException e){
	        	products = null;
	            System.out.println("Error Adding Products: " + e);
	        }
	    	//Close the connection to the database
	    	try {
	            connection.close();
	            connection = null;
	        } catch(SQLException e) {
	            System.out.println("Error closing connection: " + e);
	        }
	    	return products;
	    }
	    public Products updateProduct(Products products) {
			//Get a connection
			try {
	            connection = DriverManager.getConnection(url, username, password);
	        } catch(SQLException e) {
	            System.out.println("Error creating connection : " + e);
	            System.exit(-1);
	        }



			String query="update krishna_product set p_name=? where p_id=?";
			// prepared statements to avoid SQL injection 
			try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
				//Set the parameters 
				statement.setString(1, products.getproductName());
				statement.setInt(2, products.getProductID());
	            statement.executeUpdate();
	            System.out.println("Customer Updated successfully");

	            }
	        catch(SQLException e){
	        	products = null;
	            System.out.println("Error Updating Customer: " + e);
	        }
			try {
	            connection.close();
	            connection = null;
	        } catch(SQLException e) {
	            System.out.println("Error closing connection: " + e);
	        }
			return products;
		}

}
