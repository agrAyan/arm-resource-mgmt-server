package com.acheron.resource.mngt.service;

import java.util.List;

import com.acheron.resource.mngt.entity.Resource;
import com.acheron.resource.mngt.exception.IDNotFoundException;
import com.acheron.resource.mngt.exception.ResourceNotFoundException;

public interface IResourceService {
	public void save(Resource resource);

	public List<Resource> findAll() throws ResourceNotFoundException;

	Resource getById(int id) throws IDNotFoundException ;

	List<Resource> findResourceWithoutTaskAssigned() throws ResourceNotFoundException;
}
