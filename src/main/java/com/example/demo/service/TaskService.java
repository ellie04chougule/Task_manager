package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Task;

public interface TaskService {
	
	//list of students
	List<Task> getAllTask();
	
	//for creating and saving data into repository
	Task saveTask(Task task);
	
	//to get id 
	//For update purpose
	Task getTaskById(Long id);
	Task updateTask(Task task);
	
	//delete method
	void deleteTaskById(Long id);
}