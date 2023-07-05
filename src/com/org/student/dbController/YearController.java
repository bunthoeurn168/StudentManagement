package com.org.student.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.org.student.db.DBConnection;

public class YearController {
	public static ArrayList<String> getYeart() throws SQLException{
		String sql = "SELECT school_yr FROM tblschoolyear";
		Connection conn = DBConnection.getDBConnection().getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rst = pstm.executeQuery();
		ArrayList<String> yearList = new ArrayList<>();
		while (rst.next()) {
			yearList.add(rst.getString(1));
		}
		
		return yearList;
	}

}
