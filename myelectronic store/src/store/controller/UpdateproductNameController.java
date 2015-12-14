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
import store.dao.ProductDAO;
import store.model.Products;

public class UpdateproductNameController implements Initializable{
	private Stage dialogStage;

	//This is the Text box element in the view for first name of bank
	@FXML
	private ComboBox<String> id;
	//This is the Text box element in the view for last name of bank
	@FXML
	private TextField name;
	@FXML
	private Button button;


	//Method to set the parent stage of the current view
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ProductDAO bh = new ProductDAO();
		ArrayList<String> a = bh.udetails();
		ObservableList<String> options1 = (ObservableList<String>) FXCollections.observableArrayList(a);
		id.setItems(options1);
	}

	public void update() {
		String id = this.id.getValue();
		String name = this.name.getText();

		if(id == null || id.trim().equals("")) {
			return;
		}
		if(name == null || name.trim().equals("")) {
			return;
		}

		Products products = new Products();
		products.setProductID(Integer.parseInt(id));
		products.setProductName(name);

		// DAO instance of the model
		ProductDAO b = new ProductDAO();
		b.updateProduct(products);
		System.exit(1);

	}

	
	@FXML
	private void close() {
	    Stage stage = (Stage) button.getScene().getWindow();
	    stage.close();
	}
}
