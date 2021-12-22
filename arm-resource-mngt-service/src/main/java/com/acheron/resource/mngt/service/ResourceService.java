package com.acheron.resource.mngt.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acheron.resource.mngt.entity.Resource;
import com.acheron.resource.mngt.entity.ResourceNew;
import com.acheron.resource.mngt.exception.IDNotFoundException;
import com.acheron.resource.mngt.exception.ResourceNotFoundException;
import com.acheron.resource.mngt.repository.ResourceRepository;
import com.acheron.resource.mngt.repository.ResourceRepositoryNew;

@Service
public class ResourceService implements IResourceService {

	@Autowired
	private ResourceRepository resourceRepository;
	
	@Autowired
	private ResourceRepositoryNew resourceRepositorynew;
	
	public List<ResourceNew> getAllNew(){
		return resourceRepositorynew.findAll();
	}
	
	public List<ResourceNew> getFilterResource(Timestamp s, Timestamp e){
		return resourceRepositorynew.getResource(s, e);
	}

	@Override
	public void save(Resource resource) {
		resourceRepository.save(resource);
	}

	public List<Resource> findAll() throws ResourceNotFoundException{
		List<Resource> resourceList = resourceRepository.findAll();
		if (resourceList.isEmpty())
			throw new ResourceNotFoundException("Resource Not Available.. ");
		return resourceList;
	}

	@Override
	public List<Resource> findResourceWithoutTaskAssigned() throws ResourceNotFoundException {

		List<Resource> allResource = resourceRepository.getResourceWithoutTaskAssigned();
		if (allResource.isEmpty())
			throw new ResourceNotFoundException("No resource Available.. ");
		return allResource;
	}

	@Override
	public Resource getById(int id)  throws IDNotFoundException{
		Optional<Resource> resourceById= resourceRepository.findById(id);
		if(resourceById==null) {
			throw new IDNotFoundException("No Id Found");
		}
		return resourceById.get();
	}
}
