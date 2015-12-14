package store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import store.model.Customer;

public class UpdateCustomer {
	private Connection connection;
	//Database connection parameters
    private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
    private String username = "fpuser";
    private String password = "510";

    public ArrayList<String>customer_details(){
    	//Get connection
    	try {
            connection = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.out.println("Error creating connection : " + e);
            System.exit(-1);
        }
    	String query = "select Distinct(ID) from krishna_customers";
    	ArrayList<String>customer_list = new ArrayList<String>();
    	try(PreparedStatement statement = connection.prepareStatement(query)){
    		//execute query
    		ResultSet resultset = statement.executeQuery();
    		while(resultset.next()){
    			customer_list.add(resultset.getString(1));
    		}
    		return customer_list;
    	}catch(Exception e){
    	System.out.println("Error in loggin in"+e);
    	return null;
    }
}
    public Customer update(Customer member){
    	try {
            connection = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.out.println("Error creating connection : " + e);
            System.exit(-1);
        }
    	String query="update krishna_customers set fullname=?, emailID=?, phonenumber=?, city=? where ID=?";
    	try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
    		statement.setString(1, member.getFullname());
			statement.setString(2, member.getEmailid());
			statement.setInt(3, member.getPhonenumber());
			statement.setString(4, member.getCity());
			statement.setInt(5, member.getId());

    		statement.executeUpdate();
    		System.out.println("Customer Updated successfully");

        }
    catch(SQLException e){
    	member = null;
        System.out.println("Error Updating Customer: " + e);
    }
	try {
        connection.close();
        connection = null;
    } catch(SQLException e) {
        System.out.println("Error  in closing connection: " + e);
    }
	return member;
}

}
