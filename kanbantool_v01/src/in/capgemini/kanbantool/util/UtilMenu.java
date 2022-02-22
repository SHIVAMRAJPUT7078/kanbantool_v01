package in.capgemini.kanbantool.util;

import java.util.List;
import java.util.Scanner;

import in.capgemini.kanbantool.exception.ProductNotFoundException;
import in.capgemini.kanbantool.modal.Project;
import in.capgemini.kanbantool.service.ProjectService;
import in.capgemini.kanbantool.serviceimpl.ProjectServiceimpl;

public class UtilMenu {
	private ProjectService projectService;
	public UtilMenu() {
		projectService = new ProjectServiceimpl();
	}
	

	private void showMenu() {
		System.out.println("------ KANBAN TOOL (PROJECT MANAGEMENT TOOL) ------");
		System.out.println("1. Create Project");
		System.out.println("2. list Projects");
		System.out.println("3. Update Project");
		System.out.println("4. Delete Project");
		System.out.println("0. Exit");
		
	}
	
	public void start() {
		String continueChoice;
		int choice;
		Scanner sc = new Scanner(System.in);
		
		do {
			showMenu();
			System.out.println("Enter your Choice : (1,2,3,4,0) : ");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				Project project = new Project();
				System.out.println("---Add Operation---");
				System.out.println("Enter Project Name");
				project.setProjectName(sc.nextLine());
				System.out.println("Enter Project Identifier");
				project.setProjectIdentifier(sc.nextLine());
				System.out.println("Enter Project Description");
				project.setDescription(sc.nextLine());
				projectService.createProject(project);
				System.out.println("Project Created Successfully");
				System.out.println();
				sc.nextLine();
				break;
			case 2:
				System.out.println("---List Operation---");
				List<Project> projects = projectService.showAllProjects();
				if(projects.size() > 0) {
					for(Project pro : projects) {
						System.out.println(pro);
					}
				}
				else {
					System.out.println("There is no project availabe ");
				}
				sc.nextLine();
				break;
			case 3:
				System.out.println("---Update Operation---");
				System.out.println("Enter the id of project you want to chnage the description");
				int idToUpdate = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter the updated description");
				String description = sc.nextLine();
				projectService.updateProject(idToUpdate, description);
				System.out.println("Project Updated Successfully !!");
				break;
			case 4:
				System.out.println("---Delete Operation---");
				System.out.println("Enter id of project to delete");
				int id = sc.nextInt();
				try {
					projectService.removeProject(id);
					System.out.println("Project removed successfully !");
				} catch (ProductNotFoundException e) {
					System.out.println("Problem is " +  e.getMessage());
				}
				sc.nextLine();		
				break;
			case 0:
				System.out.println("******** Thanks for using the tool ********");
				System.exit(0);
				break;
			default :
				System.out.println("Wrong Choice");
				break;
			}
			System.out.println("Do you want to continue");
			
			continueChoice = sc.nextLine();
			
		} while (continueChoice.equals("yes"));
		System.out.println("******** Thanks for using the tool ********");
		System.out.println("Have a good day !!!");
		
	
		
	}

	
}
