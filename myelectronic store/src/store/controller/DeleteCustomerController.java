package store.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import store.dao.CustomerDAO;
import store.model.Customer;
import store.model.Users;

public class DeleteCustomerController implements Initializable {

	private Stage dialogStage;

	@FXML
	private ComboBox<String> Memberid;
	@FXML
	private Button button;
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		//  Auto-generated method stub
		CustomerDAO bh = new CustomerDAO();
		ArrayList<String> a = bh.details();
		ObservableList<String> options1 = (ObservableList<String>) FXCollections.observableArrayList(a);
		Memberid.setItems(options1);

	}

	
	public void del() {  // a method to delete from database

		String customerid = this.Memberid.getValue();

		if(customerid == null) {
			return;
		}
		Customer member = new Customer();
		Users user = new Users();
		member.setEmailid(customerid);
		user.setEmailid(customerid);
		CustomerDAO b = new CustomerDAO();
		b.delete(member,user);
		System.exit(1);
	}
	@FXML
	private void cancel() {
		// get a handle to the stage
	    Stage stage = (Stage) button.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}



}