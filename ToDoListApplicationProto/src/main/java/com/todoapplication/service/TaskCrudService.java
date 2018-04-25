package com.todoapplication.service;

import java.util.Collection;

import com.todoapplication.models.Tasks;

public interface TaskCrudService {

	/**
	 * 
	 * @return
	 */
	Collection<Tasks> getAllTasks();

	/**
	 * 
	 * @param id
	 * @return
	 */
	Tasks getTaskById(long id);

	/**
	 * 
	 * @param id
	 */
	void deleteTask(long id);

	/**
	 * 
	 * @param editedTask
	 * @param id
	 */
	void editTask(Tasks editedTask, long id);

	/**
	 * 
	 * @param task
	 */
	void saveTask(Tasks task);
}
