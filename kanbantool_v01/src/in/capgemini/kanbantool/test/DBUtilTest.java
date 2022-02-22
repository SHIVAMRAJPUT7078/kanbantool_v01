package in.capgemini.kanbantool.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.capgemini.kanbantool.util.DBUtil;

public class DBUtilTest  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DBUtil dbUtil = new DBUtil();
		
		String sql = "insert into projects (projectName,projectIdentifier,description) values (?,?,?)";
		PreparedStatement pstmt = dbUtil.preparedStatement(sql);
		
		try {
			pstmt.setString(1,"First Project");
			pstmt.setString(2,"fp01");
			pstmt.setString(3,"This is my First Project");
			pstmt.execute();
			System.out.println("Project Created Successfully !!");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			dbUtil.closePreparedStatement();
			dbUtil.closeConnection();
		}
		
		
	}

}
