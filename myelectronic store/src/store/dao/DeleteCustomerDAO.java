package store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import store.model.Customer;


public class DeleteCustomerDAO {
	private Connection connection;
    private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
    private String username = "fpuser";
    private String password = "510";

    public ArrayList<String>delete_details(){
    	try {
            connection = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.out.println("Error creating connection: " + e);
            System.exit(-1);
        }
    	String query = "select Distinct(emailID) from krishna_customers";
    	ArrayList<String>product_list = new ArrayList<String>();
    	try(PreparedStatement statement = connection.prepareStatement(query)){
    		//execute query
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
    public void delete(Customer member){
    	try {
            connection = DriverManager.getConnection(url, username, password);
        } catch(SQLException e) {
            System.out.println("Error creating connection: " + e);
            System.exit(-1);
        }
    	String query = "DELETE FROM krishna_customers where emailID = ? ";
    	//Use prepared statements to avoid SQL injection attacks
    	try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
    		statement.setString(1, member.getEmailid());

    		statement.executeUpdate();


    	} catch(SQLException e){
        	System.out.println("Error in the  Deleting Customer: " + e);
        }
    	String query1 = "DELETE FROM krishna_user where emailID = ? ";
    	try(PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)){
    		statement.setString(1, member.getEmailid());
    		statement.executeUpdate();
    	} catch(SQLException e){
        	System.out.println("Error in  Deleting the Customer: " + e);
        }
		try {
            connection.close();
            connection = null;
        } catch(SQLException e) {
            System.out.println("Error closing  of connection: " + e);
        }
    }

}
