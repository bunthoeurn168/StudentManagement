package com.org.student.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.org.student.db.DBConnection;

public class SkillController {
	public static ArrayList<String> getSkill() throws SQLException{
		String sql = "SELECT skill_name FROM tblskill";
		Connection conn = DBConnection.getDBConnection().getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rst = pstm.executeQuery();
		ArrayList<String> skillList = new ArrayList<>();
		while (rst.next()) {
			skillList.add(rst.getString(1));
		}
		
		return skillList;
	}
}
