package com.nano.todoapp.pojo;

import java.util.Date;

//import javax.persistence.Entity;
//
//@Entity
public class Todo {

	private int id;
	
	private String title;
	
	private Date completeBy;
	
	public Todo() {}
	
	public Todo(int id, String title, Date completeBy) {
		this.id = id;
		this.title = title;
		this.completeBy = completeBy;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Date getCompleteBy() {
		return completeBy;
	}
	
	public void setCompleteBy(Date completeBy) {
		this.completeBy = completeBy;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", completeBy=" + completeBy + "]";
	}
	
	
}
