package store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import store.model.Products;

public class DeleteproductDAO {
	private Connection connection;
    private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
    private String username = "fpuser";
    private String password = "510";

    public ArrayList<String>delete_details(){
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
    	System.out.println("Error in login"+e);
    	return null;
    }
}
    public void delete(Products products){
    	try {
            connection = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.out.println("Error creating connection : " + e);
            System.exit(-1);
        }
    	String query = "DELETE FROM krishna_product where p_id = ? ";
    	try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
    		statement.setInt(1, products.getProductID());

    		statement.executeUpdate();

    	} catch(SQLException e){
        	System.out.println("Error in Deletion of  Customer: " + e);
        }
		try {
            connection.close();
            connection = null;
        } catch(SQLException e) {
            System.out.println("Error in closing of  connection: " + e);
        }
    }

}
