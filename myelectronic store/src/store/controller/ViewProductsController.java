
	package store.controller;
	import java.net.URL;
	import java.util.ArrayList;
	import java.util.ResourceBundle;
	import store.dao.ProductDAO;
	import store.dao.ViewDAO;
import store.dao.ViewProductsDAO;
import store.model.Customer;
	import store.model.Products;
	import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;
	import javafx.fxml.FXML;
	import javafx.fxml.Initializable;
	import javafx.scene.control.Button;
	import javafx.scene.control.ComboBox;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.VBox;
	import javafx.stage.Stage;
	public class ViewProductsController implements Initializable{
	private Stage dialogStage;
	@FXML
	private VBox vbox;

	public void setDialogStage(Stage dialogStage) {
	this.dialogStage = dialogStage;
	}
	public void initialize(URL arg0, ResourceBundle arg1) {
		ProductDAO bh = new ProductDAO();
	ArrayList<String> a = bh.udetails();
	ObservableList<String> options1 = (ObservableList<String>) FXCollections.observableArrayList(a);
	view();
	}
	// update the form to database
	public void view() {
	
	ViewProductsDAO viewProductsDAO = new ViewProductsDAO();
	ArrayList<Products> products = viewProductsDAO.getProducts();
	for(Products Products : products) {
	TextField textField = new TextField();
	textField.setText(Products.getProductID() + " " + Products.getproductName()  );
	
	vbox.getChildren().add(textField);
	}
	
	}
	
	@FXML
	private void cancel() {
	}
	}
	
	
	

