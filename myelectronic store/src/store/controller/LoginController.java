package store.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import store.dao.LoginDAO;
import store.model.Users;

public class LoginController {

	private Stage dialogStage;
	
	// Text box field for username
	@FXML
	private TextField username;
	// Text box field for password
	@FXML
	private TextField password;

	@FXML
	private Button login;
	
	@FXML
	private Button id;

	@FXML
	private Label status;

	@FXML
	private Button button;

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	// a Method for  Login
	public void loginNext() throws IOException {
		if (username.getText().equals("admin") && password.getText().equals("master")) {
			status.setText("Login Successful");
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/store/view/AdminHomePanel.fxml"));
	        AnchorPane root = (AnchorPane) loader.load();
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	}
		else{
		String username = this.username.getText();
		String password = this.password.getText();



		if (username == null || username.trim().equals("")) {
			return;
		}
		if (password == null || password.trim().equals("")) {
			return;
		}
		// Create the model object
		Users users = new Users();

		users.setEmailid(username);
		users.setPassword(password);

		LoginDAO log = new LoginDAO();
		Users user = new Users();
		user = log.validate(username, password);

		String u = user.getEmailid();
		String p = user.getPassword();
		if (u == "" && p == "") {
			setTextVal("Invalid Login");
		} else {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/store/view/UserHomePanel.fxml"));
	        AnchorPane root = (AnchorPane) loader.load();
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.show();
		}


	}}



	@FXML
	private void cancel() {
	    Stage stage = (Stage) button.getScene().getWindow();
	    stage.close();
	}

	public void setTextVal(String text) {
		status.setText(text);
	}

}