package store.dao;

import java.sql.DriverManager;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import store.model.Users;

public class LoginDAO {
	
	 private Connection connection;
	// Database connection parameters
	 private String url = "jdbc:mysql://www.papademas.net:3306/dbfp";
	 private String username = "fpuser";
	 private String password = "510";
	// Method to check correct username and password or not
	 public Users validate(String user , String pass) {
		 Users ul=new Users();

	  // Get a connection
		  try {
			   connection = DriverManager.getConnection(url, username, password);
			  } catch (SQLException e) {
			   System.out.println("Error creating connection to database: " + e);
			   System.exit(-1);
			  }

		  // Query to select a record from the user table
		  String query = "select * from krishna_user where emaildID = " + "'" + user + "'" + "and password = " + "'" + pass
		    + "'";

		  try (PreparedStatement statement = connection.prepareStatement(query)) {
		   
		   ResultSet resultSet = statement.executeQuery();
		   if (!resultSet.first()) {
			   ul.setEmailid("");
			   ul.setPassword("");
			   } else {

			    ul.setEmailid(user);
			    ul.setPassword(pass);

			   }
			  } catch (Exception e) {

			   System.out.println("Error in Signing in  " + e);
			  }
			  try {
			   connection.close();
			   connection = null;
			  } catch (SQLException e) {
			   System.out.println("Error in closing : " + e);
			  }
			return ul;
			 }
	 }
