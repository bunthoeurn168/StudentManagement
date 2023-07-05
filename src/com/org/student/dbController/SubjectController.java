package com.org.student.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.org.student.db.DBConnection;

public class SubjectController {
	public static ArrayList<String> getSubject() throws SQLException{
		String sql = "SELECT subject_name FROM tblsubject";
		Connection conn = DBConnection.getDBConnection().getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rst = pstm.executeQuery();
		ArrayList<String> subjectList = new ArrayList<>();
		while (rst.next()) {
			subjectList.add(rst.getString("subject_name"));
		}
		
		return subjectList;
	}

}
