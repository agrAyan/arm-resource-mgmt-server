package com.acheron.resource.mngt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acheron.resource.mngt.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

	List<Task> findByDurationLessThan(float availableHours);
	List<Task> findByProjectProjectId(int projectId);
}
