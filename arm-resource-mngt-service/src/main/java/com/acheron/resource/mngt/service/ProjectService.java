package com.acheron.resource.mngt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acheron.resource.mngt.entity.Campaign;
import com.acheron.resource.mngt.entity.Project;
import com.acheron.resource.mngt.exception.IDNotFoundException;
import com.acheron.resource.mngt.exception.ProjectNotFoundException;
import com.acheron.resource.mngt.repository.CampaignRepository;
import com.acheron.resource.mngt.repository.ProjectRepository;

@Service
public class ProjectService implements IProjectService {

	@Autowired
	ProjectRepository projectRepository;
	
	@Autowired
	CampaignRepository campaignRepository;

	@Override
	public List<Project> getAllProject()  throws ProjectNotFoundException{
		List<Project> projectList= projectRepository.findAll();
		if(projectList.isEmpty()) {
			throw new ProjectNotFoundException("No Project found");
		}
		return projectList;
	}

	@Override
	public void save(Project project) {
		projectRepository.save(project);
	}

	@Override
	public Project getById(int id) throws IDNotFoundException {
		Optional<Project> projectById=projectRepository.findById(id);
		if(projectById==null) {
			throw new IDNotFoundException("Id not found");
		}
		return projectById.get();
	}

	@Override
	public List<Project> getProjectsOfOneCampiagn(int campaignId) throws IDNotFoundException {
		
		return projectRepository.findByCampaignCampaignId(campaignId);
	}

	@Override
	public Project addProject(Integer campaignId, Project project) {
		Campaign campaignById=null;
		if(campaignId!=null) {
			campaignById=campaignRepository.getById(campaignId);
		}
		project.setCampaign(campaignById);
		Project projectAdded= projectRepository.save(project);
		if(projectAdded==null) 
			throw new RuntimeException("cannot added a project");
		return projectAdded;
				
	}

}
