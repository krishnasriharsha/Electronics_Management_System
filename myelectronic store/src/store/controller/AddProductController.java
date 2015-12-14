package store.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import store.dao.ProductDAO;
import store.model.Products;

public class AddProductController {


	private Stage dialogStage;
	@FXML
	private TextField productID;
	@FXML
	private TextField productname;
	@FXML
	private Button button;
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	public void nextpage() {
		
		String productID = this.productID.getText(); // for retrival of data 
		String productname = this.productname.getText();

		if(productID == null || productID.trim().equals("")) {
			return;
		}
		if(productname == null || productname.trim().equals("")) {
			return;
		}

		Products products = new Products();
		products.setProductName(productname);
		products.setProductID(Integer.parseInt(productID));

		ProductDAO b = new ProductDAO();
		b.addProduct(products);
		System.exit(1);
		}

	//Method to close the window
	@FXML
	private void close() {
		Stage stage = (Stage) button.getScene().getWindow();
	    stage.close();
	}
}
