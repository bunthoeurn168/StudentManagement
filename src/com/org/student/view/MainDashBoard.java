package com.org.student.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainDashBoard {
	public static void frmLayout(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainDashBoard.class.getResource("MainDashboard.fxml"));
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
	private void fnStudent(ActionEvent event){
		((Node)event.getSource()).getScene().getWindow().hide();
		StudentView.studentInfo();
	}
}
