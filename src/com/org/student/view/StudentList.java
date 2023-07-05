package com.org.student.view;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import com.org.student.db.DBConnection;
import com.org.student.dbController.StudentController;
import com.org.student.model.Student;
import com.org.student.util.AlertMessage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class StudentList implements Initializable{

	@FXML private TableView<Student> tableView;
	@FXML private TableColumn<Student, String> colStudId;
	@FXML private TableColumn<Student, String> colName;
	@FXML private TableColumn<Student, String> colGender;
	@FXML private TableColumn<Student, String> colTelephone;
	@FXML private TableColumn<Student, String> colAddress;
	@FXML private TableColumn<Student, String> colEmail;
	@FXML private TableColumn<Student, String> colCourse;
	@FXML private TableColumn<Student, String> colYear;
	@FXML private TableColumn<Student, String> colSubject;
	@FXML private TableColumn<Student, String> colSkill;
	@FXML private TableColumn<Student, String> colShift;
	@FXML private TableColumn<Student, String> editCol;
	
	ObservableList<Student> listView = FXCollections.observableArrayList();
	
	static String stud_id = "", stud_no = "", email = "", fullname = "", telephone = "", address = "", gender = "", course_name = "", subject_name = "", school_yr = "", skill_name = "", shift = "";

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadData();
	}
	public void loadData(){
		colStudId.setCellValueFactory(new PropertyValueFactory<>("stud_no"));
		colName.setCellValueFactory(new PropertyValueFactory<>("fullname"));
		colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		colTelephone.setCellValueFactory(new PropertyValueFactory<>("telephone"));
		colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
		colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
		colCourse.setCellValueFactory(new PropertyValueFactory<>("course_name"));
		colYear.setCellValueFactory(new PropertyValueFactory<>("school_yr"));
		colSkill.setCellValueFactory(new PropertyValueFactory<>("skill_name"));
		colSubject.setCellValueFactory(new PropertyValueFactory<>("subject_name"));
		colShift.setCellValueFactory(new PropertyValueFactory<>("shift"));
		try {
			String sql = "SELECT * FROM tblstudent;";
			Connection conn = DBConnection.getDBConnection().getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rst = pstm.executeQuery();
			while (rst.next()) {
				listView.add(new Student(rst.getString("stud_id"), rst.getString("stud_no"), rst.getString("fullname"), rst.getString("gender"), rst.getString("telephone"), rst.getString("address"), rst.getString("email"), rst.getString("course_name"), rst.getString("school_yr"), rst.getString("skill_name"), rst.getString("subject_name"), rst.getString("shift")));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		tableView.setItems(listView);
	}
	@FXML
	private void fnRegister(MouseEvent event){
		((Node)event.getSource()).getScene().getWindow().hide();
		StudentManagementController.register();
	}
	
	@FXML
	private void handleDeleteStudent(MouseEvent event) throws SQLException {
		try {
			int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
		    Student student = tableView.getItems().get(selectedIndex);
		    
		    String id = student.getStud_id();
		  
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			alert.setHeaderText("Are you sure to delete student Id: " + student.getStud_no());
			alert.setContentText("Press Ok to delete.");
			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == ButtonType.OK){
				if (selectedIndex >= 0) {
					tableView.getItems().remove(selectedIndex);
			    	StudentController.deleteStudent(id);
			    	refreshTable(event);
				} else {
					AlertMessage.errorBox("There is an error deleting Student", "Delete Student", null);
				}			
			}
		} catch (Exception e) {
			AlertMessage.errorBox("You are null selected record", "Error Delete", null);
		}
	}
	@FXML
	public void handleUpdateStudent(MouseEvent event){
	    try {
	    	int selectedIndex = tableView.getSelectionModel().getSelectedIndex();
		    Student student = tableView.getItems().get(selectedIndex);
		    stud_id = student.getStud_id();
		    stud_no = student.getStud_no();
		    fullname = student.getFullname();
		    telephone = student.getTelephone();
		    email = student.getEmail();
		    address = student.getAddress();
		    gender = student.getGender();
		    course_name = student.getCourse_name();
		    subject_name = student.getSubject_name();
		    school_yr = student.getSchool_yr();
		    skill_name = student.getSkill_name();
		    shift = student.getShift();
		    StudentManagementController.updateStudent();
		    
		} catch (Exception e) {
			AlertMessage.errorBox("You are null selected record", "Error Update", null);
		}
	}
	@FXML
	public void refreshTable(MouseEvent event){
		listView.clear();
		loadData();
	}
	
//    @FXML
//    private void close(MouseEvent event) {
//        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
//        stage.close();
//    }
	
    @FXML
    void Back(MouseEvent event) {
    	((Node)event.getSource()).getScene().getWindow().hide();
    	StudentView.studentInfo();
    }

}
