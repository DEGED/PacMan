package ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	@Override
	public void start(Stage stage) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("PacMansGUI.fxml"));
		
		Parent root = loader.load();
		/*
		 * 
		 
		CircleController guiController = loader.getController();
    	stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent we) {
                try {
					guiController.onCloseRequest();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
            }
        });
        */
		Scene scene = new Scene(root);
		stage.setTitle("Catch The Pac Man");
		stage.setScene(scene);
		stage.show();
	}

}
