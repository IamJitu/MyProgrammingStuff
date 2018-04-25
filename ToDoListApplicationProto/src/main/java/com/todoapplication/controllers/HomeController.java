package com.todoapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todoapplication.models.Tasks;
import com.todoapplication.repositories.TasksRepository;

@RestController
@RequestMapping("tasks")
public class HomeController {
	
	@Autowired
	private TasksRepository tasksRepository;
	
	@GetMapping("/{id}")
	public List<Tasks> getAllTasks(@PathVariable("id") final int taskArchivedFalse) {
		return this.tasksRepository.findByTaskarchived(taskArchivedFalse);
	}
	
	@PostMapping
	public void addTask(@RequestBody final Tasks todo) {
		this.tasksRepository.save(todo);
	}
	
	
}	