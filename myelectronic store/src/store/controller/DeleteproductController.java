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
import store.dao.DeleteproductDAO;
import store.model.Products;

public class DeleteproductController implements Initializable{
		private Stage dialogStage;

		    //Text box field for id of movie
		@FXML
		private ComboBox<String> Productid;
		@FXML
		private Button button;

		//Method to set the parent stage
		public void setDialogStage(Stage dialogStage) {
			this.dialogStage = dialogStage;
		}
		public void initialize(URL arg0, ResourceBundle arg1) {
			//  Auto-generated method stub
			DeleteproductDAO bh = new DeleteproductDAO();
			ArrayList<String> a = bh.delete_details();
			ObservableList<String> options1 = (ObservableList<String>) FXCollections.observableArrayList(a);
			Productid.setItems(options1);
		}

		public void del() {

			String productid = this.Productid.getValue();
			if(Productid == null) {
				return;
			}

			Products products = new Products();
			products.setProductID(Integer.parseInt(productid));

			DeleteproductDAO b = new DeleteproductDAO();
			b.delete(products);
			System.exit(1);
		}

		@FXML
		private void close() {
		    Stage stage = (Stage) button.getScene().getWindow();
		    stage.close();
		}

}
