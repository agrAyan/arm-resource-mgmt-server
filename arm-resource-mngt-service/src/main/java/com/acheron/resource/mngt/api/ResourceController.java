package com.acheron.resource.mngt.api;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.acheron.resource.mngt.entity.Campaign;
import com.acheron.resource.mngt.entity.Resource;
import com.acheron.resource.mngt.entity.ResourceNew;
import com.acheron.resource.mngt.exception.IDNotFoundException;
import com.acheron.resource.mngt.exception.ResourceNotFoundException;
import com.acheron.resource.mngt.service.ResourceService;
import com.acheron.resource.mngt.vo.ResourceVO;

@RestController
public class ResourceController {
	
	/**
	 * @author AyanAgrawal
	 */

	@Autowired
	private ResourceService resourceService;

	/**
	 * gets all resource
	 * and filtering unwanted columns i.e., using ResourceVO
	 * @return ResourceVO list object as response entity 
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/resources")
	public ResponseEntity<List<ResourceVO>> getAllResource() throws ResourceNotFoundException{
		List<ResourceVO> resourceVOs = new ArrayList<ResourceVO>();
		List<Resource> resourceList = resourceService.findAll();
		for (Resource resource : resourceList) {
			DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
			dozerBeanMapper.setMappingFiles(Arrays.asList("mapping\\mapper.xml"));
			ResourceVO resourceVO = dozerBeanMapper.map(resource, ResourceVO.class);
			resourceVOs.add(resourceVO);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get All Resources");
		return ResponseEntity.ok().headers(headers).body(resourceVOs);
	}

	/**
	 * get non allocated resources
	 * and filtering unwanted columns i.e., using ResourceVO
	 * @return ResourceVO list object as response entity
	 */
	@GetMapping("/resources/without-task")
	public ResponseEntity<List<ResourceVO>> getResourceWithoutTaskAssigned() {
		List<ResourceVO> resourceVOs = new ArrayList<ResourceVO>();
		List<Resource> resourceList = resourceService.findResourceWithoutTaskAssigned();
		for (Resource resource : resourceList) {
			DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
			dozerBeanMapper.setMappingFiles(Arrays.asList("mapping\\mapper.xml"));
			ResourceVO resourceVO = dozerBeanMapper.map(resource, ResourceVO.class);
			resourceVOs.add(resourceVO);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get All Resources with free task");
		return ResponseEntity.ok().headers(headers).body(resourceVOs);
	}

	/**
	 * gets resource by id
	 * @param id
	 * @return resource object
	 */
	@GetMapping("/resources/{resource-id}")
	Resource getById(@PathVariable("resource-id") int id) {
		return resourceService.getById(id);
	}

	@GetMapping("resources/new")
	List<ResourceNew> getNewR() {
		return resourceService.getAllNew();
	}
	
	@GetMapping("/resource/start-date/{start-date}/end-date/{end-date}")
	public ResponseEntity<List<ResourceNew>> getfILTERrESOURCE(@PathVariable("start-date") String startDate, @PathVariable("end-date") String endDate)throws IDNotFoundException{
		System.out.println(startDate);
		Timestamp str= Timestamp.valueOf(startDate);
		Timestamp endD= Timestamp.valueOf(endDate);
		List<ResourceNew> resource= resourceService.getFilterResource(str, endD);
		HttpHeaders headers = new HttpHeaders();
		headers.add("desc", "Get Campaign By ID");
		return ResponseEntity.ok().headers(headers).body(resource);
	}
}