package com.org.student.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class StudentManagementController {
	public static void register(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(StudentView.class.getResource("StudentRegister.fxml"));
			BorderPane rootLayout = loader.load();
			Scene scene = new Scene(rootLayout);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void studentManagement(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(StudentManagementController.class.getResource("StudentManagement.fxml"));
			BorderPane root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void studentList(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(StudentManagementController.class.getResource("StudentList.fxml"));
			BorderPane root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void updateStudent(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(StudentManagementController.class.getResource("UpdateStudent.fxml"));
			BorderPane root = loader.load();
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}











