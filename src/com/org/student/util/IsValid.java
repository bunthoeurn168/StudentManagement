package com.org.student.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.TextField;

public class IsValid {
	public static final String regexName = "^[a-zA-Z ]*$";
	public static final String regexPass = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20}$";
	public static final String regexre_pass = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20}$";
	public static final String regexPhone = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$";
	public static final String regexEmail = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
	
	public static boolean valid(String strMatcher, String regex){
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher = pattern.matcher(strMatcher);
    	return matcher.matches();
    }
	public boolean validateEmpty(TextField txt){
		if (txt.getText().isEmpty()) {
			AlertMessage.infoBox("Please Fill Required Fields..!", "Field Blank", null);
			return false;
		}
		return true;
	}
	public boolean validateId(TextField txt){
		if (txt.getText().matches("^([a-zA-Z_$][a-zA-Z\\d_$]*)$")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean validateName(TextField txt){
		
		if (txt.getText().matches("^[a-zA-Z ]*$")) {
			return true;
		} else {
			AlertMessage.errorBox("Invalid name, Name except only character.", "Invalid", null);
			return false;
		}
	}
	public boolean validatePhone(TextField txt){
		if (txt.getText().matches("^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$")) {
			return true;
		} else {
			AlertMessage.errorBox("Invalid phone number", "Invalid Phone number", null);
			return false;
		}
	}
	public boolean validateEmail(TextField txt){
		if (txt.getText().matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}")) {
			return true;
		} else {
			AlertMessage.errorBox("Invalid email", "Invalid email", null);
			return false;
		}
	}
	
//	public boolean validateCourse(ComboBox<String> combo){
//		if (combo.getSelectionModel().isEmpty()) {
//			AlertMessage.warningBox("Please select Course", "Empty value", null);
//			return true;
//		} else {
//			return false;
//		}
//	}
}























