package com.acheron.resource.mngt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acheron.resource.mngt.entity.Resource;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {

	@Query(value = "select *  from resource where resource_id not in (Select resource_id from task where resource_id is not null)", nativeQuery = true)
	List<Resource> getResourceWithoutTaskAssigned();
	
	
}
