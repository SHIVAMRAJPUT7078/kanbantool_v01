package in.capgemini.kanbantool.service;

import java.util.List;

import in.capgemini.kanbantool.domain.Project;
import in.capgemini.kanbantool.exception.ProductNotFoundException;



/**
 * this ProjectService will perform all the business logic on Project 
 * @author hsraj
 *
 */
public interface ProjectService {
/*
 * create project - Check Project availability - remove Project Update project
 * */
	/**
	 * this createProject will create the project in the system
	 * @param project to be created
	 */
	void createProject(Project project);
	/**
	 * this showAllProjects will return the list of avaivale project
	 * @return list of available project
	 */
	List<Project> showAllProjects();
	/**
	 * this updateProject will update the project detail based on provided project
	 * @param project to be updated
	 */
	void updateProject(int id,String description);
	/**
	 * this remove method will remove the project based on the provided id
	 * @param id of the project to be removed
	 * @throws ProductNotFoundException 
	 */
	void removeProject(int id) throws ProductNotFoundException;
}
