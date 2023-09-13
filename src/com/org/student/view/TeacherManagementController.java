package com.org.student.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TeacherManagementController {
	public static void register(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TeacherView.class.getResource("TeacherRegister.fxml"));
			BorderPane rootLayout = loader.load();
			Scene scene = new Scene(rootLayout);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
