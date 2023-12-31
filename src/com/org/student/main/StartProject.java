package com.org.student.main;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class StartProject extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
//			Parent root = FXMLLoader.load(getClass().getResource("../view/Login.fxml"));
			Parent root = FXMLLoader.load(getClass().getResource("../view/TeacherRegister.fxml"));
//			Parent root = FXMLLoader.load(getClass().getResource("../view/MainDashboard.fxml"));
			primaryStage.setTitle("Student System");
			primaryStage.setScene(new Scene(root));
	primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../other/img/login.png")));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
