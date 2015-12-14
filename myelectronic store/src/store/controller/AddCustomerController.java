package store.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import store.dao.CustomerDAO;
import store.model.Customer;

public class AddCustomerController {

	private Stage dialogStage;
	@FXML
	private TextField name;
	@FXML
	private TextField pswd;
	@FXML
	private TextField emailid;
	@FXML
	private TextField number;
	@FXML
	private TextField city;
	@FXML
	private Button button;
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	//Method to save the details into  database
	public void nextpage() {
		//extract the data
		String name = this.name.getText();
		String pswd = this.pswd.getText();
		String emailid = this.emailid.getText();
		String number = this.number.getText();
		String city = this.city.getText();

		if(name == null || name.trim().equals("")) {
			return;
		}
		if(pswd == null || pswd.trim().equals("")) {
			return;
		}
		if(emailid == null || emailid.trim().equals("")) {
			return;
		}
		if(number == null || number.trim().equals("")) {
			return;
		}
		if(city == null || city.trim().equals("")) {
			return;
		}
		// this is an object for model
		Customer member = new Customer();
		//for setting the values from the input form 
		member.setFullname(name);
		member.setPassword(pswd);
		member.setEmailid(emailid);
		member.setPhonenumber(Integer.parseInt(number));
		member.setCity(city);

		
		CustomerDAO b = new CustomerDAO();// DAO instance of model 
		b.create(member);
		System.exit(1);
	}

	
	@FXML
	private void closewindow() {
	    Stage stage = (Stage) button.getScene().getWindow();
	    stage.close();
	}
}