package com.org.student.util;

import javafx.scene.control.Alert;
import javafx.stage.StageStyle;

public class AlertMessage {
	public static void infoBox(String infoMessage, String titleBar, String headerMessage){
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.initStyle(StageStyle.UTILITY);
		alert.setTitle(titleBar);
		alert.setHeaderText(headerMessage);
		alert.setContentText(infoMessage);
		alert.showAndWait();
	}
	public static void warningBox(String infoMessage, String titleBar, String headerMessage){
		Alert alert = new Alert(Alert.AlertType.WARNING);
		alert.initStyle(StageStyle.UTILITY);
		alert.setTitle(titleBar);
		alert.setHeaderText(headerMessage);
		alert.setContentText(infoMessage);
		alert.showAndWait();
	}
	public static void errorBox(String infoMessage, String titleBar, String headerMessage){
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.initStyle(StageStyle.UTILITY);
		alert.setTitle(titleBar);
		alert.setHeaderText(headerMessage);
		alert.setContentText(infoMessage);
		alert.showAndWait();
	}
}
