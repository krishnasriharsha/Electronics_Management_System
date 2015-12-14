package store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import store.model.Customer;
import store.model.Products;
import store.model.Users;

public class CustomerDAO {

	//Connection object
	private Connection connection;
	//Database connection parameters
    private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
    private String username = "fpuser";
    private String password = "510";

    public ArrayList<String>details(){
    	//Get connection
    	try {
            connection = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.out.println("Error connection to database: " + e);
            System.exit(-1);
        }
    	String query = "select Distinct(emailID) from krishna_customers";
    	ArrayList<String>product_list = new ArrayList<String>();
    	try(PreparedStatement statement = connection.prepareStatement(query)){
    		ResultSet resultset = statement.executeQuery();
    		while(resultset.next()){
    			product_list.add(resultset.getString(1));
    		}
    		return product_list;
    	}catch(Exception e){
    	System.out.println("Error in logging in"+e);
    	return null;
    }

}
    public ArrayList<String>details1(){
    	try {
            connection = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        }
    	String query = "select Distinct(ID) from krishna_customers";
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
	public Customer create(Customer member) {
		try {
            connection = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        }
		// insert a record to the  table
		String query1 = "INSERT INTO krishna_user (emaildID, password) VALUES (?, ?);";
		// prepared statements to avoid SQL injection attacks
		try(PreparedStatement statement = connection.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, member.getEmailid());
            statement.setString(2, member.getPassword());
           
            statement.executeUpdate();


        } catch(SQLException e){
        	member = null;
            System.out.println("Error Creating User: " + e);
        }
		String query = "INSERT INTO krishna_customers (fullname, emailID, phonenumber, city) VALUES (?, ?, ?, ?);";		//Use prepared statements to avoid SQL injection attacks
				try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
		            statement.setString(1, member.getFullname());
		            statement.setString(2, member.getEmailid());
		            statement.setInt(3, member.getPhonenumber());
		            statement.setString(4, member.getCity());
		            statement.executeUpdate();
		            ResultSet resultSet = statement.getGeneratedKeys();
		            if(resultSet.next()) {
		            	member.setId(resultSet.getInt(1));
		            }
				} catch(SQLException e){
		        	member = null;
		            System.out.println("Error Creating User: " + e);
				}

		try {
            connection.close();
            connection = null;
        } catch(SQLException e) {
            System.out.println("Error closing connection: " + e);
        }
		return member;
	}

	public Customer update(Customer member) {
		try {
            connection = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        }



		String query="update krishna_customers set fullname=?, phonenumber=?, city=? where ID=?";
		// prepared statements to avoid SQL injection attacks
		try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
			statement.setString(1, member.getFullname());
			statement.setInt(2, member.getPhonenumber());
			statement.setString(3, member.getCity());
			statement.setInt(4, member.getId());
            statement.executeUpdate();
            System.out.println("Customer Updated");

            }
        catch(SQLException e){
        	member = null;
            System.out.println("Error Updating Customer: " + e);
        }
		try {
            connection.close();
            connection = null;
        } catch(SQLException e) {
            System.out.println("Error closing connection: " + e);
        }
		return member;
	}
	public void delete(Customer member, Users u){
    	try {
            connection = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.out.println("Error creating connection to database: " + e);
            System.exit(-1);
        }
    	String query = "DELETE FROM krishna_customers where emailID = ? ";
    	try{
    		PreparedStatement statement = connection.prepareStatement("DELETE FROM krishna_customers where emailID = ? ");
    		statement.setString(1, member.getEmailid());
    		statement.executeUpdate();
    		System.out.println("Customer Removed");

    	} catch(SQLException e){
        	System.out.println("Error Deleting Customer: " + e);
        }
    	String query1 = "DELETE FROM krishna_user where emaildID = ? ";
    	try{
    		PreparedStatement st = connection.prepareStatement("DELETE FROM krishna_user where emaildID = ?");
    		st.setString(1, u.getEmailid());
      		st.executeUpdate();
      		System.out.println("Deleted Credentails ");
    	} catch(SQLException e){
        	System.out.println("Error in Deleting Customer: " + e);
        }
		try {
            connection.close();
            connection = null;
        } catch(SQLException e) {
            System.out.println("Error : " + e);
        }
    }


}

