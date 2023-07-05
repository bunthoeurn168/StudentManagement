package com.org.student.view;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.org.student.dbController.LoginController;
import com.org.student.util.AlertMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;

public class LoginFormController implements Initializable{
	@FXML private BorderPane layout;
	@FXML private TextField usernameField;
	@FXML private PasswordField pwdField;
	@FXML private Button Login;
	Tooltip tooltip, tooltipUsername, tooltipPassword;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tooltip = new Tooltip();
		tooltipUsername = new Tooltip("Enter Username");
		usernameField.setTooltip(tooltipUsername);
		tooltipPassword = new Tooltip("Enter Password");
		pwdField.setTooltip(tooltipPassword);
	}
	
	
	@FXML
	private void Login(ActionEvent event) throws ClassNotFoundException, IOException{
		String username = usernameField.getText();
		String password = pwdField.getText();
		
		if(username.isEmpty() || password.isEmpty()){
			AlertMessage.infoBox("Username & Password Required", "Login", null);
		}else{
			if (username.startsWith("admin")) {
				try {
					if (LoginController.Login(username, password)) {
						((Node)event.getSource()).getScene().getWindow().hide();
						MainDashBoard.frmLayout();
					} else {
						AlertMessage.infoBox("Invalid Username or Password..!", "Login", null);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else if((username.startsWith("teacher"))){
				try {
					if (LoginController.Login(username, password)) {
						BorderPane user = FXMLLoader.load(getClass().getResource("PrintStudent.fxml"));
						layout.getChildren().setAll(user);
					} else {
						AlertMessage.infoBox("Invalid Username or Password..!", "Login", null);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else{
				AlertMessage.infoBox("Invalid Username or Password..!", "Login", null);
			}
		}
	}
	
	@FXML
	private void fnRegister(){
		
	}
	@FXML
	private void frmForgotAccount(){
		AlertMessage.infoBox("Please contact to your adminstrative", "Forgot Password", null);
	}
}























