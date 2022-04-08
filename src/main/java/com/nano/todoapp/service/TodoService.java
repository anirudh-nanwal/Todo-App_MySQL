package com.nano.todoapp.service;

import java.util.List;

import com.nano.todoapp.pojo.Todo;
import com.nano.todoapp.pojo.TxnStatus;

public interface TodoService {

	public List<Todo> getTodos();
	
	public Todo getTodo(int id);
	
	public TxnStatus addTodo(Todo todo);
	
	public TxnStatus deleteTodo(int todo);
}
