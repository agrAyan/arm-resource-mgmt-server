package com.acheron.resource.mngt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acheron.resource.mngt.entity.Resource;
import com.acheron.resource.mngt.entity.Task;
import com.acheron.resource.mngt.exception.IDNotFoundException;
import com.acheron.resource.mngt.exception.TaskNotFoundException;
import com.acheron.resource.mngt.repository.ResourceRepository;
import com.acheron.resource.mngt.repository.TaskRepository;

@Service
public class TaskService implements ITaskService {

	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	ResourceRepository resourceRepository;

	@Override
	public List<Task> getAllTask() throws TaskNotFoundException {
		List<Task> taskList= taskRepository.findAll();
		if(taskList.isEmpty())
			throw new TaskNotFoundException("Task is not available");
		return taskList;
	}

	@Override
	public void createTasks(Task tasks) {
		taskRepository.save(tasks);
		
	}
	
	@Override
	public List<Task> getByDurationLessThan(float availableHours) throws TaskNotFoundException{
		List<Task> taskDuration=taskRepository.findByDurationLessThan(availableHours);
		if(taskDuration.isEmpty())
			throw new TaskNotFoundException("Duration is not available");
		return taskDuration;
	}

	@Override
	public Task getById(int id) throws IDNotFoundException {
		Optional<Task> taskById=taskRepository.findById(id);
		if(taskById==null) {
			throw new IDNotFoundException("No Id Found");
		}
		return taskById.get();
	}
	
	public List<Task> getTasksByProjectId(int projectId){
		return taskRepository.findByProjectProjectId(projectId);
	}
	
	public Task updateTask(Task task) {
		Task taskUpdated= taskRepository.save(task);
		if(taskUpdated==null)
			throw new RuntimeException("task cannot be updated");
		return taskUpdated;
	}
}
