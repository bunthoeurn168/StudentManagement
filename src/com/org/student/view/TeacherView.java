package com.org.student.view;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TeacherView {
	public static void teacherInfo(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TeacherView.class.getResource("Teacher.fxml"));
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
	private void teachRegister(ActionEvent event){
		((Node)event.getSource()).getScene().getWindow().hide();
		TeacherManagementController.register();
	}
	@FXML
	private void manageTeacher(ActionEvent event){
		
	}
	
    @FXML
    void Back(MouseEvent event) {
    	((Node)event.getSource()).getScene().getWindow().hide();
    	MainDashBoard.frmLayout();
    }
}
