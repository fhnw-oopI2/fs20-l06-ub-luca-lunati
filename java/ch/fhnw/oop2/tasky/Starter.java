package ch.fhnw.oop2.tasky;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Starter extends Application {
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 800;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Scene scene = new Scene(new ApplicationUI());
		primaryStage.setResizable(false);
		primaryStage.setTitle("Tasky");
		primaryStage.setScene(scene);
		primaryStage.setWidth(WIDTH);
		primaryStage.setHeight(HEIGHT);
		primaryStage.show();
	}

}
