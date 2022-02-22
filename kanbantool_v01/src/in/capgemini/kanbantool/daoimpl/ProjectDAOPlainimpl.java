package in.capgemini.kanbantool.daoimpl;

import java.util.ArrayList;
import java.util.List;

import in.capgemini.kanabantool.dao.ProjectDAO;
import in.capgemini.kanbantool.exception.ProductNotFoundException;
import in.capgemini.kanbantool.modal.Project;

/**
 * this ProjectDAOPlainimpl is for the basic CRUD functionality on List collection
 * @author hsraj
 *
 */
public class ProjectDAOPlainimpl implements ProjectDAO {

	List<Project> localRepository;
	
	public ProjectDAOPlainimpl() {
		localRepository = new ArrayList<>();
	}
	@Override
	public void save(Project project) {
		localRepository.add(project);
		
		
	}

	@Override
	public void update(int id,String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Project> list() {
		// TODO Auto-generated method stub
//		return list;
		return localRepository;
	}
	@Override
	public void delete(int id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		//loop throuth the local repository 
		//if found then take out the object and break the loop 
		//otherwise throw ProductNotFoundException
		boolean isFound = false;
		for(Project project : localRepository) {
			if(project.getId() == id) {
				isFound = true;
				localRepository.remove(project);
				break;
			}
			else{
				isFound = false;
			}
		}
		if(!isFound) {
			throw new ProductNotFoundException("Project is not found with ID: " + id);
		}
		
	}

	

}
