package com.acheron.resource.mngt.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.acheron.resource.mngt.entity.Campaign;
import com.acheron.resource.mngt.entity.Resource;
import com.acheron.resource.mngt.entity.ResourceNew;

@Repository
public interface ResourceRepositoryNew extends JpaRepository<ResourceNew, Integer> {

	//@Query(value = "select *  from resource where resource_id not in (Select resource_id from task where resource_id is not null)", nativeQuery = true)
	//List<Resource> getResourceWithoutTaskAssigned();
//	
//	@Query(value=("SELECT * from arm.campaign where\r\n"
//			+ "(start_date BETWEEN ?1 AND ?2) OR \r\n"
//			+ "(end_date BETWEEN ?1 AND ?2) OR \r\n"
//			+ "(start_date <= ?1 AND end_date >= ?2);"),nativeQuery=true)
	
	@Query("from ResourceNew r left join r.taskList t where (t.startDate between ?1 and ?2) or (t.endDate between ?1 and ?2) or  (t.startDate <= ?1 AND t.endDate >= ?2)")
	List<ResourceNew> getResource(Timestamp startDate, Timestamp endDate);
	
}
