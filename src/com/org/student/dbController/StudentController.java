package com.org.student.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.org.student.db.DBConnection;
import com.org.student.model.Student;

public class StudentController {
	
	
	
	public static int addStudent(Student student) throws SQLException{
		String sql = "INSERT INTO public.tblstudent(stud_no, fullname, gender, address, telephone, email, shift, course_name, subject_name, school_yr, skill_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		Connection conn = DBConnection.getDBConnection().getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setObject(1, student.getStud_no());
		pstm.setObject(2, student.getFullname());
		pstm.setObject(3, student.getGender());
		pstm.setObject(4, student.getAddress());
		pstm.setObject(5, student.getTelephone());
		pstm.setObject(6, student.getEmail());
		pstm.setObject(7, student.getShift());
		pstm.setObject(8, student.getCourse_name());
		pstm.setObject(9, student.getSubject_name());
		pstm.setObject(10, student.getSchool_yr());
		pstm.setObject(11, student.getSkill_name());
		
		return pstm.executeUpdate();
	}
	public static Student listStudent(){
		try {
			String sql = "SELECT * FROM tblstudent;";
			Connection conn = DBConnection.getDBConnection().getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rst = pstm.executeQuery();
			while (rst.next()) {
				Student student = new Student(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11), rst.getString(12));
				return student;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	public static Student searchStudent(String stud_no) throws SQLException{
		String sql = "SELECT * FROM tblstudent WHERE stud_no=?";
		Connection conn = DBConnection.getDBConnection().getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setObject(1, stud_no);
		
		ResultSet rst = pstm.executeQuery();
		if(rst.next()){
			Student student = new Student(rst.getString("stud_id"), rst.getString("stud_no"), rst.getString("fullname"), rst.getString("gender"), rst.getString("telephone"), rst.getString("address"), rst.getString("email"), rst.getString("course_name"), rst.getString("school_yr"), rst.getString("skill_name"), rst.getString("subject_name"), rst.getString("shift"));
			return student;
		}
		return null;
	}
	public static int updateStudent(Student student) throws SQLException{
		String sql = "UPDATE tblstudent SET stud_no = ?, fullname = ?, gender = ?, telephone = ?, address = ?, email = ?, course_name = ?, school_yr = ?, skill_name = ?, subject_name = ?, shift = ? WHERE stud_id = '" + student.getStud_id() + "'";
		Connection conn = DBConnection.getDBConnection().getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setObject(1, student.getStud_no());
		pstm.setObject(2, student.getFullname());
		pstm.setObject(3, student.getGender());
		pstm.setObject(4, student.getTelephone());
		pstm.setObject(5, student.getAddress());
		pstm.setObject(6, student.getEmail());
		pstm.setObject(7, student.getCourse_name());
		pstm.setObject(8, student.getSchool_yr());
		pstm.setObject(9, student.getSkill_name());
		pstm.setObject(10, student.getSubject_name());
		pstm.setObject(11, student.getShift());
		
		return pstm.executeUpdate();
	}
	public static int deleteStudent(String stu_id) throws SQLException{
		String sql = "DELETE FROM tblstudent WHERE stud_id = '" + stu_id + "'";
		Connection conn = DBConnection.getDBConnection().getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		return pstm.executeUpdate();
	}
    public boolean checkNo(String stud_no){
        boolean checkNo = false;
        try {
        	String SQL = "SELECT stud_no FROM tblstudent WHERE stud_no = ?";
        	Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setObject(1, stud_no);
            ResultSet rst = pstm.executeQuery();
            if(rst.next()){
            	checkNo = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
         return checkNo;
    }  
    public boolean checkPhone(String phone){
        ResultSet rs;
        boolean checkPhone = false;
        try {
        	String SQL = "SELECT telephone FROM tblstudent WHERE telephone = ?";
        	Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setString(1, phone);
            rs = pstm.executeQuery();
            if(rs.next()){
                checkPhone = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
         return checkPhone;
    }
    public boolean checkEmail(String email){
        ResultSet rs;
        boolean checkEmail = false;
        try {
        	String SQL = "SELECT email FROM tblstudent WHERE email = ?";
        	Connection conn = DBConnection.getDBConnection().getConnection();
            PreparedStatement pstm = conn.prepareStatement(SQL);
            pstm.setString(1, email);
            rs = pstm.executeQuery();
            if(rs.next()){
                checkEmail = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
         return checkEmail;
    }
}



































