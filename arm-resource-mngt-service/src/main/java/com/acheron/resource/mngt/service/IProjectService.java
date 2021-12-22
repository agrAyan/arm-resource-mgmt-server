package com.acheron.resource.mngt.service;

import java.util.List;

import com.acheron.resource.mngt.entity.Campaign;
import com.acheron.resource.mngt.entity.Project;
import com.acheron.resource.mngt.exception.IDNotFoundException;
import com.acheron.resource.mngt.exception.ProjectNotFoundException;

public interface IProjectService {

	public List<Project> getAllProject() throws ProjectNotFoundException;

	public void save(Project project);
	
	Project getById(int id) throws IDNotFoundException;
	
	List<Project> getProjectsOfOneCampiagn(int campaignId) throws IDNotFoundException;
	
	public Project addProject(Integer campaignId, Project project);
}
