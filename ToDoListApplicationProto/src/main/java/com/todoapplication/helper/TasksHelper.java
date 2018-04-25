package com.todoapplication.helper;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.todoapplication.exception.ResourceNotFoundException;
import com.todoapplication.models.Tasks;
import com.todoapplication.repositories.TasksRepository;

@Component
public class TasksHelper {

	@Autowired
	TasksRepository tasksRepository;

	/**
	 * 
	 * @return List Of Tasks
	 */
	public Collection<Tasks> fetchAllTasks() {
		Collection<Tasks> resultSet = this.tasksRepository.findAllCustom();
		return resultSet;
	}

	/**
	 * 
	 * @param id
	 * @return Task
	 */
	public Tasks getTaskById(long id) {
		return  Optional.ofNullable(tasksRepository.findById(id))
				.orElseThrow(() -> new ResourceNotFoundException("Tasks", "id", id));
	}

	/**
	 * 
	 * @param tasks
	 */
	public void saveTask(Tasks tasks) {
		tasksRepository.save(tasks);
	}

	/**
	 * 
	 * @param id
	 */
	public void deleteTask(long id) {
		Tasks task = Optional.ofNullable(tasksRepository.findById(id))
		.orElseThrow(() -> new ResourceNotFoundException("Tasks", "id", id));
		tasksRepository.delete(task);
	}

	/**
	 * 
	 * @param editedTask
	 * @param id
	 */
	public void editTask(Tasks editedTask, long id) {
		Optional.ofNullable(tasksRepository.findById(id))
				.orElseThrow(() -> new ResourceNotFoundException("Tasks", "id", id));
		editedTask.setId(id);
		tasksRepository.saveAndFlush(editedTask);
	}
}
