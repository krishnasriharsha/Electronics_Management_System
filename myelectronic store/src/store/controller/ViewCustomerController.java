package store.controller;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import store.dao.ProductDAO;
import store.dao.ViewDAO;
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
public class ViewCustomerController implements Initializable{
private Stage dialogStage;
@FXML
private VBox vbox;

public void setDialogStage(Stage dialogStage) {
this.dialogStage = dialogStage;
}
public void initialize(URL arg0, ResourceBundle arg1) {
// TODO Auto-generated method stub
ProductDAO bh = new ProductDAO();
ArrayList<String> a = bh.udetails();
ObservableList<String> options1 = (ObservableList<String>) FXCollections.observableArrayList(a);
view();
}
public void view() {
//Extracting the data from the view elements
ViewDAO viewDAO = new ViewDAO();
ArrayList<Customer> customers = viewDAO.getCustomers();
for(Customer customer : customers) {
TextField textField = new TextField();
textField.setText(customer.getId() + " " + customer.getFullname() + " " + customer.getCity() );
TextField atextField = new TextField();
atextField.setText (customer.getFullname() + " " + customer.getCity() );
vbox.getChildren().add(textField);
vbox.getChildren().add(atextField);
}

}

@FXML
private void cancel() {
}
}