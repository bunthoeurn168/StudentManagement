package com.org.student.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class StudentView {
	public static void studentInfo(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(StudentView.class.getResource("Student.fxml"));
			AnchorPane rootLayout = loader.load();
			Scene scene = new Scene(rootLayout);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
	private void fnRegister(ActionEvent event){
		((Node)event.getSource()).getScene().getWindow().hide();
		StudentManagementController.register();
	}
	
	@FXML
	private void fnManagement(ActionEvent event){
		((Node)event.getSource()).getScene().getWindow().hide();
		StudentManagementController.studentManagement();
	}
	@FXML
	private void fnListStudent(ActionEvent event){
		((Node)event.getSource()).getScene().getWindow().hide();
		StudentManagementController.studentList();
	}
    @FXML
    void Back(MouseEvent event) {
    	((Node)event.getSource()).getScene().getWindow().hide();
    	MainDashBoard.frmLayout();
    }
	
}















