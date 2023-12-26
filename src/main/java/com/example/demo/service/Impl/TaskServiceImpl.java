package com.example.demo.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;


@Service
public class TaskServiceImpl implements TaskService{
	
	private TaskRepository TaskRepository;

	
	//constructor
	public TaskServiceImpl(TaskRepository TaskRepository) {
		super();
		this.TaskRepository = TaskRepository;
	}


	//it will return all the data from the repository
	@Override
	public List<Task> getAllTask() {
		// TODO Auto-generated method stub
		return TaskRepository.findAll();
	}


	@Override
	public Task saveTask(Task task) {
		// TODO Auto-generated method stub
		
		return TaskRepository.save(task);
	}


	//Get student id from repo
	@Override
	public Task getTaskById(Long id) {
		// TODO Auto-generated method stub
		return TaskRepository.findById(id).get();
	}


//	Now Save updated data into repo 
	@Override
	public Task updateTask(Task task) {
		// TODO Auto-generated method stub
		return TaskRepository.save(task);
	}


	@Override
	public void deleteTaskById(Long id) {
		// TODO Auto-generated method stub
		TaskRepository.deleteById(id);
		
	}


	
}