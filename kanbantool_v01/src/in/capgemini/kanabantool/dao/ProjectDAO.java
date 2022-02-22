package in.capgemini.kanabantool.dao;

import java.util.List;

import in.capgemini.kanbantool.exception.ProductNotFoundException;
import in.capgemini.kanbantool.modal.Project;

/**
 * This project DAO interface will work on the CRUD for Project
 * @author hsraj
 *
 */

public interface ProjectDAO {
	/**
	 * this save method will save the data in the database
	 * @param project to be saved in the DB
	 */
	void save(Project project);
	/**
	 * this update method will update the project detail.
	 * @param project to be updated
	 */
	void update(int id,String description);
	
	/**
	 * this list method will return all the project list
	 * @return List of the projects if found
	 */
	List<Project> list();
	/**
	 * this delete method will delete the project based on id provided
	 * @param id of the project to be deleted if found
	 */
	void delete(int id) throws ProductNotFoundException;
 } 