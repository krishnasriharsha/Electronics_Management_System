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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import store.dao.CustomerDAO;
import store.model.Customer;

public class UpdateCustomerController implements Initializable{
	private Stage dialogStage;

	@FXML
	private ComboBox<String> id;
	@FXML
	private TextField name;
		@FXML
	private TextField number;
	@FXML
	private TextField city;
	@FXML
	private Button button;

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		CustomerDAO bh = new CustomerDAO();
		ArrayList<String> a = bh.details1();
		ObservableList<String> options1 = (ObservableList<String>) FXCollections.observableArrayList(a);
		id.setItems(options1);

	}

	public void updateAction() {
		String id = this.id.getValue();
		String name = this.name.getText();
		String number = this.number.getText();
		String city = this.city.getText();


		// data validation
		if(name == null || name.trim().equals("")) {
			return;
		}
		
		if(number == null || number.trim().equals("")) {
			return;
		}
		if(city == null || city.trim().equals("")) {
			return;
		}

		Customer member = new Customer();
		member.setId(Integer.parseInt(id));
		member.setFullname(name);
		member.setPhonenumber(Integer.parseInt(number));
		member.setCity(city);

		CustomerDAO b = new CustomerDAO();
		b.update(member);
		System.exit(1);

	}


	@FXML
	private void close() {
	    Stage stage = (Stage) button.getScene().getWindow();
	    stage.close();
	}
}
