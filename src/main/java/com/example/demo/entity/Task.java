package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "tasks")
public class Task {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	
	private String firstTask;
	
	
	
	//default constructor
	public Task() {
		
	}
	
	
	//Parameterized constructor
	public Task(String firstTask) {
		super();
		this.firstTask = firstTask;
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getFirstTask() {
		return firstTask;
	}


	public void setFirstTask(String firstTask) {
		this.firstTask = firstTask;
	}


	
	
}
