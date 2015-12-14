package store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import store.model.OrderRefurbishedproduct;

public class OrderRefurbishedproductDAO {
			private Connection connection;
		    private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
		    private String username = "fpuser";
		    private String password = "510";

		    public ArrayList<String>product_details(){
		    	try {
    	            connection = DriverManager.getConnection(url, username, password);
    	        } catch(SQLException e) {
    	            System.out.println("Error creating connection : " + e);
    	            System.exit(-1);
    	        }
		    	String query = "select Distinct(p_name) from krishna_product";
		    	ArrayList<String>product_list = new ArrayList<String>();
		    	try(PreparedStatement statement = connection.prepareStatement(query)){
		    		ResultSet resultset = statement.executeQuery();
		    		while(resultset.next()){
		    			product_list.add(resultset.getString(1));
		    		}
		    		return product_list;
		    	}catch(Exception e){
		    	System.out.println("Error in loggin "+e);
		    	return null;
		    }
		}
		    public OrderRefurbishedproduct create(OrderRefurbishedproduct product){
		    	try {
    	            connection = DriverManager.getConnection(url, username, password);
    	        } catch(SQLException e) {
    	            System.out.println("Error creating connection : " + e);
    	            System.exit(-1);
    	        }
		    	String query = "INSERT INTO krishna_orderrefurbished(id, productname, quantity) VALUES (?, ?, ?)";
		    	try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
		    		statement.setInt(1, product.getCustomerID());
		    		statement.setString(2, product.getProductName());
		    		statement.setInt(3, product.getRentDay());

		    		//Execute
		    		statement.executeUpdate();

		    		ResultSet resultset = statement.getGeneratedKeys();
		    		if(resultset.next()){
		    			//set the id  to the field
		    			product.setRentID(resultset.getInt(1));
		    		}
		    	}catch(SQLException e){
		    		product = null;
		    		System.out.println("Error closing connection:"+e);
		    	}
		    	return product;
		    }

}
