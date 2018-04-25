package com.todoapplication.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapplication.helper.TasksHelper;
import com.todoapplication.models.Tasks;
import com.todoapplication.service.TaskCrudService;
@Service
public class TaskCrudServiceImpl implements TaskCrudService{
	
	@Autowired
	TasksHelper tasksHelper;

	@Override
	public Collection<Tasks> getAllTasks() {
		return tasksHelper.fetchAllTasks();
	}

	@Override
	public Tasks getTaskById(long id) {
		return tasksHelper.getTaskById(id);
	}

	@Override
	public void deleteTask(long id) {
		tasksHelper.deleteTask(id);		
	}

	@Override
	public void editTask(Tasks editedTask, long id) {
		tasksHelper.editTask(editedTask, id);		
	}

	@Override
	public void saveTask(Tasks task) {
		tasksHelper.saveTask(task);		
	}

}
