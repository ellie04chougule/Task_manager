package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;

import jakarta.servlet.http.HttpSession;



@Controller
public class TaskController {
	
	
	private TaskService TaskService;

	//constructor
	public TaskController(TaskService TaskService) {
		super();
		this.TaskService = TaskService;
	}
	
	
	//handler to remove popup success message as blank 
	@PostMapping("/resetSuccessMessage")
	public ResponseEntity<Void> resetSuccessMessage(HttpSession session) {
		session.removeAttribute("successMessage");
	    return ResponseEntity.ok().build();
	}
	
	
	//handler method to handle the list of students and return model and view
	
	
	@GetMapping("/tasks")
	public String listTask(Model model) {
		
		model.addAttribute("tasks", TaskService.getAllTask());
		return "Task";
	}
	
	
	@GetMapping("/tasks/new")
	public String createTaskForm(Model model) {
		Task task = new Task();
		model.addAttribute("tasks", task);
		return "create_task";
	}
	
	
	//to save new data through create_student.html from into repo 
	
	@PostMapping("/tasks")
	public String savetask(@ModelAttribute("tasks") Task task, HttpSession session) {
		TaskService.saveTask(task);
		session.setAttribute("successMessage", "Successfully Added");
		return "redirect:/tasks";
	}
	
	@GetMapping("/tasks/edit/{id}")
	public String editTaskForm(@PathVariable Long id, Model model) {
		model.addAttribute("task", TaskService.getTaskById(id));
		return "edit_task";
	}
	
	
	
	//update method handler
	@PostMapping("/tasks/{id}")
	public String updataTask(@PathVariable Long id, @ModelAttribute("student") Task task, Model model, HttpSession session) {
		//first get student from database by id and then save 
		Task existingTask = TaskService.getTaskById(id);
		
		existingTask.setId(id);
		existingTask.setFirstTask(task.getFirstTask());
		
		
		//Now data has been edited 
		//so no update this by calling update function
		
		TaskService.updateTask(existingTask);
		session.setAttribute("successMessage", "Successfully Updated");
		
		return "redirect:/tasks";	
	}
	
	//handler method for delete student
	@GetMapping("/tasks/{id}")
	public String deletTask(@PathVariable Long id, HttpSession session) {
		TaskService.deleteTaskById(id);
		session.setAttribute("successMessage", "Successfully deleted");
		return "redirect:/tasks";
	}
	
	
	
	
	
	
	

	
}
