package in.capgemini.kanbantool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.capgemini.kanbantool.domain.Project;
import in.capgemini.kanbantool.service.ProjectService;
 
@Controller
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping("/home.ds")
	public String showHomePage() {
		return "home";
	}
	
	@RequestMapping(value="/processForm.ds",method = RequestMethod.POST)
	public String processProjectForm(@ModelAttribute("project") Project project) {
		System.out.println(project);
		projectService.createProject(project);
		return "projectList";
	}
}
  