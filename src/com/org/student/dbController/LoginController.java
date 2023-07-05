package com.org.student.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.org.student.db.DBConnection;

public class LoginController {
	public static boolean Login(String username, String password) throws SQLException{
		String SQL = "SELECT log_username, log_password FROM tbllogin WHERE log_username=? AND log_password=?";
		Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement pstm = conn.prepareStatement(SQL);
        pstm.setObject(1, username);
        pstm.setObject(2, password);
		ResultSet rs = pstm.executeQuery();
		if (rs.next()) {
			if (!rs.getString(1).equals(username)) {
				return false;
			}
			String pwd = rs.getString(2);
			if(pwd.equals(password)){
				return true;
			}
		}
		return false;
		
	}
}
