package com.org.student.view;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

import com.org.student.dbController.CourseController;
import com.org.student.dbController.SkillController;
import com.org.student.dbController.StudentController;
import com.org.student.dbController.SubjectController;
import com.org.student.dbController.YearController;
import com.org.student.model.Student;
import com.org.student.util.AlertMessage;
import com.org.student.util.IsValid;

public class UpdateStudent implements Initializable{
	private ToggleGroup toggleGroup = new ToggleGroup();
	@FXML private TextField stud_idField;
	@FXML private TextField stud_noField;
	@FXML private TextField nameField;
	@FXML private RadioButton maleField;
	@FXML private RadioButton femalField;
	@FXML private TextField telephoneField;
	@FXML private TextField addressField;
	@FXML private TextField emailField;
	@FXML private ComboBox<String> courseBox;
	@FXML private ComboBox<String> yearBox;
	@FXML private ComboBox<String> skillBox;
	@FXML private ComboBox<String> subjectBox;
	@FXML private CheckBox morningCheck;
	@FXML private CheckBox afternoonCheck;
	@FXML private CheckBox eveningCheck;
	
	
	@FXML
	public void updateStudent(ActionEvent event){
		try {
			IsValid v = new IsValid();
			if (v.validateEmpty(stud_noField) && v.validateEmpty(nameField) && v.validateEmpty(addressField) && v.validateEmpty(emailField) && v.validateEmpty(telephoneField)
					&& v.validateEmail(emailField) && v.validateName(nameField) && v.validatePhone(telephoneField)) {
				String stud_id = stud_idField.getText();
				String stud_no = stud_noField.getText();
				String telephone = telephoneField.getText();
				String email = emailField.getText();
				String fullname = nameField.getText();
				String address = addressField.getText();
				maleField.setToggleGroup(toggleGroup);
				femalField.setToggleGroup(toggleGroup);
				RadioButton btnRadio = (RadioButton) toggleGroup.getSelectedToggle();
				String gender = btnRadio.getText();
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
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
				alert.setTitle("Confirmation Dialog");
				alert.setHeaderText("Are you sure to update: ");
				alert.setContentText("Press Ok to delete.");
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK){
					Student student = new Student(stud_id, stud_no, fullname, gender, telephone, address, email, course_name, school_yr, skill_name, subject_name, shift);
					int i = StudentController.updateStudent(student);	
					if (i > 0) {
						AlertMessage.infoBox("Updated Successfully..!", "Student Register", null);
						((Node)event.getSource()).getScene().getWindow().hide();
					} else {
						AlertMessage.errorBox("OOPs there is an error updating Student", "Student Update", null);
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
    @FXML
    private void Back(MouseEvent event) {
    	((Node)event.getSource()).getScene().getWindow().hide();
    	StudentView.studentInfo();
    }

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		stud_idField.setText(StudentList.stud_id);
		stud_noField.setText(StudentList.stud_no);
		nameField.setText(StudentList.fullname);
		telephoneField.setText(StudentList.telephone);
		emailField.setText(StudentList.email);
		addressField.setText(StudentList.address);
		
		if("Male".equals(StudentList.gender)){
			maleField.setSelected(true);
			femalField.setSelected(false);
		}else{
			femalField.setSelected(true);
			maleField.setSelected(false);
		}
		
		courseBox.getSelectionModel().select(StudentList.course_name);
		yearBox.getSelectionModel().select(StudentList.school_yr);
		skillBox.getSelectionModel().select(StudentList.skill_name);
		subjectBox.getSelectionModel().select(StudentList.subject_name);
		
		if ("Morning".equals(StudentList.shift)) {
			morningCheck.setSelected(true);
			afternoonCheck.setSelected(false);
			eveningCheck.setSelected(false);
		} else if("Afternoon".equals(StudentList.shift)){
			morningCheck.setSelected(false);
			afternoonCheck.setSelected(true);
			eveningCheck.setSelected(false);
		} else{
			morningCheck.setSelected(false);
			afternoonCheck.setSelected(false);
			eveningCheck.setSelected(true);
		}
		loadCourseBox();
		loadSubjectBox();
		loadYearBox();
		loadSkillBox();
	}
}










