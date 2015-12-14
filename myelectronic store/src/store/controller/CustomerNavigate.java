package store.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CustomerNavigate {

public void memberNav(ActionEvent event) throws IOException{
	Stage primaryStage = new Stage();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/store/view/AddCustomer.fxml"));
    AnchorPane root = (AnchorPane) loader.load();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
}
public void del(ActionEvent event) throws IOException{
	Stage primaryStage = new Stage();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/store/view/DeleteCustomer.fxml"));
    AnchorPane root = (AnchorPane) loader.load();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
}
public void update(ActionEvent event) throws IOException{
	Stage primaryStage = new Stage();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/store/view/UpdateCustomer.fxml"));
    AnchorPane root = (AnchorPane) loader.load();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
}
public void addProduct(ActionEvent event) throws IOException{
	Stage primaryStage = new Stage();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/store/view/AddProducts.fxml"));
    AnchorPane root = (AnchorPane) loader.load();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
}
public void deleteProduct(ActionEvent event) throws IOException{
	Stage primaryStage = new Stage();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/store/view/DeleteProducts.fxml"));
    AnchorPane root = (AnchorPane) loader.load();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
}

public void updateProductName(ActionEvent event) throws IOException{
	Stage primaryStage = new Stage();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/store/view/UpdateProducts.fxml"));
    AnchorPane root = (AnchorPane) loader.load();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
}
public void Refproduct(ActionEvent event) throws IOException{
	Stage primaryStage = new Stage();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/store/view/OrderRefurbishedproduct.fxml"));
    AnchorPane root = (AnchorPane) loader.load();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
}
public void purchaseProduct(ActionEvent event) throws IOException{
	Stage primaryStage = new Stage();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/store/view/Ordernewproduct.fxml"));
    AnchorPane root = (AnchorPane) loader.load();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
}
public void view(ActionEvent event) throws IOException{
	Stage primaryStage = new Stage();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/store/view/viewCustomer.fxml"));
    AnchorPane root = (AnchorPane) loader.load();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
}
public void viewProduct(ActionEvent event) throws IOException{
	Stage primaryStage = new Stage();
	FXMLLoader loader = new FXMLLoader(getClass().getResource("/store/view/viewProducts.fxml"));
    AnchorPane root = (AnchorPane) loader.load();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.show();
}
}