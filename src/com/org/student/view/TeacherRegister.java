package com.org.student.view;

import java.sql.SQLException;

import com.org.student.dbController.TeacherController;
import com.org.student.model.Teacher;
import com.org.student.util.AlertMessage;

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
	private void addTeacher() throws SQLException{
//		System.out.println("Techer register work...");
		String name = fullnameField.getText();
		String password = passwordField.getText();
		maleField.setToggleGroup(toggleGroup);
		femalField.setToggleGroup(toggleGroup);
		RadioButton btnRadio = (RadioButton) toggleGroup.getSelectedToggle();
		String address = addressField.getText();
		String telephone = telephoneField.getText();
		String dob = dobField.getText();
		
		String email = emailField.getText();
		String gender = btnRadio.getText();
//		System.out.println("Data: " + name + ", " + password + ", " + btnRadio + ", " + address 
//				+ ", " + telephone + ", " + dob);
		String id = "";
		Teacher teacher = new Teacher(id, name, password, gender, email, telephone, address, dob);
		System.out.println("teacher:--------------- "+teacher+"----------------");
		int i = TeacherController.addTeacher(teacher);
		System.out.println("i:-------------"+i+"-------");
		if (i > 0) {
			AlertMessage.infoBox(" Registered Successfully..!", "Student Register", null);
			
		} else {
			AlertMessage.errorBox("OOPs there is an error adding Student", "Student Registration", null);
		}	
		
	}
    @FXML
    void Back(MouseEvent event) {
    	((Node)event.getSource()).getScene().getWindow().hide();
    	TeacherView.teacherInfo();
    }
}



