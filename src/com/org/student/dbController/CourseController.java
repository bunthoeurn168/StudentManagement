package com.org.student.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.org.student.db.DBConnection;
import com.org.student.model.Course;

public class CourseController {
	public static int addCourse(Course course) throws SQLException{
		String sql = "INSERT INTO public.tblcourse(course_name, description) VALUES (?, ?);";
		Connection conn = DBConnection.getDBConnection().getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setObject(1, course.getCourse_name());
		pstm.setObject(2, course.getDescription());
		
		return pstm.executeUpdate();
	}
	
	public static ArrayList<String> getCourse() throws SQLException{
		String sql = "SELECT course_name FROM tblcourse";
		Connection conn = DBConnection.getDBConnection().getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rst = pstm.executeQuery();
		ArrayList<String> courseList = new ArrayList<>();
		while(rst.next()){
			//Course course;
			//course = new Course(rst.getString("course_name"));
			courseList.add(rst.getString("course_name"));
		}
		return courseList;
	}
}
































