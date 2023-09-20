package com.org.student.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.org.student.db.DBConnection;
import com.org.student.model.Teacher;

public class TeacherController {
	public static int addTeacher(Teacher teacher) throws SQLException{
		String sql = "INSERT INTO tblteacher(teacher_name, teacher_password, teacher_email, teacher_phone, teacher_address, teacher_gender, teacher_dob) values (?, ?, ?, ?, ?, ?, ?)";
		Connection conn = DBConnection.getDBConnection().getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setObject(1, teacher.getName());
		pstm.setObject(2, teacher.getPassword());
		pstm.setObject(3, teacher.getEmail());
		pstm.setObject(4, teacher.getTelephone());
		pstm.setObject(5, teacher.getAddress());
		pstm.setObject(6, teacher.getGender());
		pstm.setObject(7, teacher.getDob());
		
		return pstm.executeUpdate();
	}
	
	
}
