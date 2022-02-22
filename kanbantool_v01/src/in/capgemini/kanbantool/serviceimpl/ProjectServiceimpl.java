package in.capgemini.kanbantool.serviceimpl;

import java.util.Date;
import java.util.List;

import in.capgemini.kanabantool.dao.ProjectDAO;
import in.capgemini.kanbantool.daoimpl.ProjectDAOJDBCImpl;
import in.capgemini.kanbantool.daoimpl.ProjectDAOPlainimpl;
import in.capgemini.kanbantool.exception.ProductNotFoundException;
import in.capgemini.kanbantool.modal.Project;
import in.capgemini.kanbantool.service.ProjectService;

public class ProjectServiceimpl implements ProjectService {

	private ProjectDAO projectDAO;
	public ProjectServiceimpl() {
//		projectDAO = new ProjectDAOPlainimpl();
		projectDAO = new ProjectDAOJDBCImpl();
	
	}
	
	@Override
	public void createProject(Project project) {
		// TODO business logic to be implemented here
		project.setId((int)(System.currentTimeMillis()*-1));
		project.setCreatedAt(new Date());
		projectDAO.save(project);
	}

	@Override
	public List<Project> showAllProjects() {
		// TODO business logic to be implemented here
		return projectDAO.list();
	}

	@Override
	public void updateProject(int id,String description) {
		projectDAO.update(id,description);

	}

	@Override
	public void removeProject(int id) throws ProductNotFoundException {
		try {
			projectDAO.delete(id);
		} catch (ProductNotFoundException e) {
			throw new ProductNotFoundException(e.getMessage());
		}

	}

}
