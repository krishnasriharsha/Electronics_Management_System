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
import store.dao.OrderRefurbishedproductDAO;
import store.dao.OrdernewproductDAO;
import store.model.OrderRefurbishedproduct;
import store.model.Ordernewproduct;

public class OrdernewproductController implements Initializable  {
	private Stage dialogStage;
	@FXML
	private TextField custID;
	//This is the combo box element
	@FXML
	private ComboBox<String> combo;
	//This is the Text box element in the view for address of club

	@FXML
	private Button button;
	
	@FXML
	private TextField qid;



	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		OrdernewproductDAO bh = new OrdernewproductDAO();
		ArrayList<String> a = bh.product_details();
		ObservableList<String> options1 = (ObservableList<String>) FXCollections.observableArrayList(a);
		combo.setItems(options1);

	}
	public void purchase() {
		String customerID = this.custID.getText();
		String ProductName = this.combo.getValue();
		if(customerID == null || customerID.trim().equals("")){
			return;
		}
		if(ProductName == null || ProductName.trim().equals("")){
			return;
		}
		Ordernewproduct product = new Ordernewproduct();
		product.setCustomerID(Integer.parseInt(customerID));
		product.setProductName(ProductName);
		product.setQuantity(Integer.parseInt(qid.getText().trim()));
		Ordernewproduct order = new Ordernewproduct();
		order.sellable(product);	
		System.exit(1);

	}
	
	@FXML
	private void close() {
	    Stage stage = (Stage) button.getScene().getWindow();
	    stage.close();
	}

}
