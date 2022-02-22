package in.capgemini.kanbantool.test;


import java.util.Date;
import java.util.List;

import in.capgemini.kanabantool.dao.ProjectDAO;
import in.capgemini.kanbantool.daoimpl.ProjectDAOPlainimpl;
import in.capgemini.kanbantool.modal.Project;

public class ProjectDAOimpl_SaveOperationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProjectDAO projectDAO = new ProjectDAOPlainimpl();
		Project project = new Project();
		project.setId(101);
		project.setProjectName("First Name");
		project.setDescription("This is my first project");
		project.setCreatedAt(new Date());
		project.setStartDate(new Date());
		project.setEndDate(new Date());
		projectDAO.save(project);
		System.out.println("Success");
		List<Project> projects = projectDAO.list();
		System.out.println(projects);
		
		
	}

}
