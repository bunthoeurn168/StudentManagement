package com.org.student.view;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class TeacherRegister {
	private ToggleGroup toggleGroup = new ToggleGroup();
	@FXML private TextField fullnameField;
	@FXML private RadioButton maleField;
	@FXML private RadioButton femalField;
	@FXML private TextField addressField;
	@FXML private TextField telephoneField;
	@FXML private TextField emailField; 
	@FXML private PasswordField passwordField;
	@FXML private TextField dobField;
	
	@FXML
	private void addTeacher(){
		System.out.println("Techer register work...");
	}
    @FXML
    void Back(MouseEvent event) {
    	((Node)event.getSource()).getScene().getWindow().hide();
    	MainDashBoard.frmLayout();
    }
}



