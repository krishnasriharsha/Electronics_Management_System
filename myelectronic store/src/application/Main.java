package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//Create a loader 
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/store/view/Login.fxml"));
			
		
            AnchorPane root = (AnchorPane) loader.load();
            //Set the  title of the window
            primaryStage.setTitle("WELCOME TO THE ELECTRONIC STORE");
            //Create a scene 
            
            
            Scene scene = new Scene(root);
            
            
            scene.getStylesheets().add("application/application.css");
            
           // scene.getStylesheets().getClass().getResource("application.css").toExternalForm();

            //Set the scene to the stage
            primaryStage.setScene(scene);
            
            //scene.getStylesheets().getClass().getResource("application.css").toExternalForm();

          
            primaryStage.show();
		} catch(Exception e) {
			System.out.println("Error : " + e);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}