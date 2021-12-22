package com.acheron.resource.mngt.service;

import java.util.List;

import com.acheron.resource.mngt.entity.Task;
import com.acheron.resource.mngt.exception.IDNotFoundException;
import com.acheron.resource.mngt.exception.TaskNotFoundException;

public interface ITaskService {

	public List<Task> getAllTask() throws TaskNotFoundException;
	
	Task getById(int id) throws IDNotFoundException;

	public void createTasks(Task tasks);
	
	List<Task> getByDurationLessThan(float availableHours) throws TaskNotFoundException;

	List<Task> getTasksByProjectId(int projectId);
	
	public Task updateTask(Task task);
	
}
