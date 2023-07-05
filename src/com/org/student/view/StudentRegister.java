package com.org.student.view;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.org.student.dbController.CourseController;
import com.org.student.dbController.SkillController;
import com.org.student.dbController.StudentController;
import com.org.student.dbController.SubjectController;
import com.org.student.dbController.YearController;
import com.org.student.model.Student;
import com.org.student.util.AlertMessage;
import com.org.student.util.IsValid;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

public class StudentRegister implements Initializable{
	final Tooltip tooltip = new Tooltip();
	private ToggleGroup toggleGroup = new ToggleGroup();
	@FXML private TextField stud_noField;
	@FXML private TextField fullnameField;
	@FXML private RadioButton maleField;
	@FXML private RadioButton femalField;
	@FXML private TextField addressField;
	@FXML private TextField telephoneField;
	@FXML private TextField emailField;
	@FXML private CheckBox morningCheck;
	@FXML private CheckBox afternoonCheck;
	@FXML private CheckBox eveningCheck;
	@FXML private ComboBox<String> courseBox;
	@FXML private ComboBox<String> subjectBox;
	@FXML private ComboBox<String> yearBox;
	@FXML private ComboBox<String> skillBox;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tooltip.setText("Your password must be at least 8 characters in length\n");
		stud_noField.setTooltip(tooltip);
		loadCourseBox();
		loadSubjectBox();
		loadYearBox();
		loadSkillBox();
	}

	@FXML
	private void addStudent(){
		try {
			IsValid v = new IsValid();
			if (v.validateEmpty(stud_noField) && v.validateEmpty(fullnameField) && v.validateEmpty(addressField) && v.validateEmpty(emailField) && v.validateEmpty(telephoneField)
					&& v.validateEmail(emailField) && v.validateName(fullnameField) && v.validatePhone(telephoneField)) {
				StudentController st = new StudentController();
				String stud_no = stud_noField.getText();
				String telephone = telephoneField.getText();
				String email = emailField.getText();
				if (st.checkNo(stud_no)) {
					AlertMessage.errorBox("Id: " + stud_no + " has registered already", "Id Exist", null);
				}else if(st.checkPhone(telephone)){
					AlertMessage.errorBox("Telephone: " + telephone + " has registered already", "Telephone Exist", null);
				}else if(st.checkEmail(email)){
					AlertMessage.errorBox("E-mail: " + email + " has registered already", "E-mail Exist", null);
				}else{
					String fullname = fullnameField.getText();
					maleField.setToggleGroup(toggleGroup);
					femalField.setToggleGroup(toggleGroup);
					RadioButton btnRadio = (RadioButton) toggleGroup.getSelectedToggle();
					String gender = btnRadio.getText();
					String address = addressField.getText();
					
					String course_name = courseBox.getSelectionModel().getSelectedItem();
					String subject_name = subjectBox.getSelectionModel().getSelectedItem();
					String school_yr = yearBox.getSelectionModel().getSelectedItem();
					String skill_name = skillBox.getSelectionModel().getSelectedItem();
					String shift = "";
					if (morningCheck.isSelected()) {
						shift = morningCheck.getText();
					} else if(afternoonCheck.isSelected()) {
						shift = afternoonCheck.getText();
					} else{
						shift = eveningCheck.getText();
					} 
					String stud_id="";
					Student student = new Student(stud_id, stud_no, fullname, gender, telephone, address, email, course_name, school_yr, skill_name, subject_name, shift);
					int i = StudentController.addStudent(student);
					if (i > 0) {
						AlertMessage.infoBox("Student ID " + stud_no + " Registered Successfully..!", "Student Register", null);
						reset();
					} else {
						AlertMessage.errorBox("OOPs there is an error adding Student", "Student Registration", null);
					}
				}
			}
		} catch (Exception ex) {
			Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	@FXML
	private void loadCourseBox(){
		ArrayList<String> arrayList = null;
		try {
			arrayList = CourseController.getCourse();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ObservableList<String> observableArray = FXCollections.observableArrayList();
		observableArray.addAll(arrayList);
		
		if (observableArray != null) {
			courseBox.setItems(observableArray);
		}
	}
	@FXML
	private void loadSubjectBox(){
		ArrayList<String> arrayList = null;
		try {
			arrayList = SubjectController.getSubject();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ObservableList<String> observableArray = FXCollections.observableArrayList();
		observableArray.addAll(arrayList);
		if (observableArray != null) {
			subjectBox.setItems(observableArray);
		}
	}
	@FXML
	private void loadSkillBox(){
		ArrayList<String> arrayList = null;
		try {
			arrayList = SkillController.getSkill();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ObservableList<String> observableArray = FXCollections.observableArrayList();
		observableArray.addAll(arrayList);
		if (observableArray != null) {
			skillBox.setItems(observableArray);
		}
	}
	@FXML
	private void loadYearBox(){
		ArrayList<String> arrayList = null;
		try {
			arrayList = YearController.getYeart();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ObservableList<String> observableArray = FXCollections.observableArrayList();
		observableArray.addAll(arrayList);
		if (observableArray != null) {
			yearBox.setItems(observableArray);
		}
	}
	@FXML
	private void morningShift(){
		if (morningCheck.isSelected()) {
			afternoonCheck.setSelected(false);
			eveningCheck.setSelected(false);
		}
	}
	@FXML
	private void afternoonShift(){
		if (afternoonCheck.isSelected()) {
			morningCheck.setSelected(false);
			eveningCheck.setSelected(false);
		}
	}
	@FXML
	private void eveningShift(){
		if (eveningCheck.isSelected()) {
			morningCheck.setSelected(false);
			afternoonCheck.setSelected(false);
		}
	}
	@FXML
	private void reset(){
		stud_noField.clear();
		fullnameField.clear();
		femalField.setSelected(false);
		maleField.setSelected(true);
		emailField.clear();
		telephoneField.clear();
		addressField.clear();
		courseBox.valueProperty().set(null);
		subjectBox.valueProperty().set(null);
		skillBox.valueProperty().set(null);
		yearBox.valueProperty().set(null);
		morningCheck.setSelected(false);
		afternoonCheck.setSelected(false);
		eveningCheck.setSelected(false);
	}
    @FXML
    void Back(MouseEvent event) {
    	((Node)event.getSource()).getScene().getWindow().hide();
    	StudentView.studentInfo();
    }
}


























