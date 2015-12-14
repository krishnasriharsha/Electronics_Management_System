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
import store.model.OrderRefurbishedproduct;

public class OrderRefurbishedproductController implements Initializable {
		private Stage dialogStage;
		@FXML
		private TextField custID;
		// combo box element
		@FXML
		private ComboBox<String> combo;
		@FXML
		private TextField qid;

		@FXML
		private Button button;

		public void setDialogStage(Stage dialogStage) {
			this.dialogStage = dialogStage;
		}

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			OrderRefurbishedproductDAO bh = new OrderRefurbishedproductDAO();
			ArrayList<String> a = bh.product_details();
			ObservableList<String> options1 = (ObservableList<String>) FXCollections.observableArrayList(a);
			combo.setItems(options1);

		}
		public void Buy() {
			String customerID = this.custID.getText();
			String ProductName = this.combo.getValue();
			String quantity = this.qid.getText();
			if(customerID == null || customerID.trim().equals("")){
				return;
			}
			if(ProductName == null || ProductName.trim().equals("")){
				return;
			}
			if(quantity == null || quantity.trim().equals("")){
				return;
			}
			OrderRefurbishedproduct product = new OrderRefurbishedproduct();
			product.setCustomerID(Integer.parseInt(customerID));
			product.setProductName(ProductName);
			product.setRentDay(Integer.parseInt(quantity));
			OrderRefurbishedproductDAO b = new OrderRefurbishedproductDAO();
			b.create(product);
			System.exit(1);

		}

		@FXML
		private void close() {
		    Stage stage = (Stage) button.getScene().getWindow();
		    stage.close();
		}
}
