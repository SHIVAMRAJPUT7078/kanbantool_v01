package in.capgemini.kanbantool.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.capgemini.kanabantool.dao.ProjectDAO;
import in.capgemini.kanbantool.exception.ProductNotFoundException;
import in.capgemini.kanbantool.modal.Project;
import in.capgemini.kanbantool.util.DBUtil;

public class ProjectDAOJDBCImpl extends DBUtil implements ProjectDAO {

	
	@Override
	public void save(Project project) {
		String sql = "insert into projects (projectName,projectIdentifier,description) values (?,?,?)";
		PreparedStatement pstmt = preparedStatement(sql);
		try {
			pstmt.setString(1, project.getProjectName());
			pstmt.setString(2, project.getProjectIdentifier());
			pstmt.setString(3, project.getDescription());
			pstmt.execute();
		} catch (Exception e) {
			System.out.println("Problem is : "+ e.getMessage());
		}
		finally {
			closePreparedStatement();
			closeConnection();
		}
		
	}

	@Override
	public void update(int id,String description) {
		String sql = "update projects set description=? where id=?";
		PreparedStatement pstmt = preparedStatement(sql);
		try {
			pstmt.setString(1, description);
			pstmt.setInt(2, id);
			pstmt.execute();
		} catch (Exception e) {
			System.out.println("Problem is : " + e.getMessage());
		}
		finally {
			closePreparedStatement();
			closeConnection();
		}
		
	}

	@Override
	public List<Project> list() {
		String sql = "select * from projects";
		PreparedStatement pstmt = preparedStatement(sql);
		Project project;
		List<Project> projects = new ArrayList<>();
		try {
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				project = new Project();
				project.setId(rs.getInt("id"));
				project.setProjectName(rs.getString("projectName"));
				project.setProjectIdentifier(rs.getString("projectIdentifier"));
				project.setDescription(rs.getString("description"));
				//TODO : convert db date to object date
				projects.add(project);
			}
		} catch (SQLException e) {
			System.out.println("Problem is : " + e.getMessage());
		}
		finally {
			closePreparedStatement();
			closeConnection();
			
		}
		return projects;
	}

	@Override
	public void delete(int id) throws ProductNotFoundException {
		String sql = "delete from projects where id=?";
		PreparedStatement pstmt = preparedStatement(sql);
		try {
			pstmt.setInt(1,id);
			pstmt.execute();
		} catch (Exception e) {
			System.out.println("Problem is : " + e.getMessage());
		}
		finally {
			closePreparedStatement();
			closeConnection();
		}
	}

	

}
