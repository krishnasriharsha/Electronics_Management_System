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
public class ViewDAO {
private Connection connection;
private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
private String username = "fpuser";
private String password = "510";
public ArrayList<Customer> getCustomers(){
//Get connection
try {
connection = DriverManager.getConnection(url, username, password);
} catch(SQLException e) {
System.out.println("Error creating connection : " + e);
System.exit(-1);
}



String query = "select ID, fullname, emailID, phonenumber, city from krishna_customers";
ArrayList<Customer> customers = new ArrayList<Customer>();
try(PreparedStatement statement = connection.prepareStatement(query)){
//execute query
	
	
ResultSet resultset = statement.executeQuery();
while(resultset.next()){
Customer customer = new Customer();
customer.setId(resultset.getInt(1));
customer.setFullname(resultset.getString(2));
customer.setEmailid(resultset.getString(3));
customer.setPhonenumber(resultset.getInt(4));
customer.setCity(resultset.getString(5));
customers.add(customer);
}
return customers;
}catch(Exception e){
System.out.println("Error in loggin "+e);
return null;
}
}
}
	


