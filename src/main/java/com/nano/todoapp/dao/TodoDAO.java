package com.nano.todoapp.dao;

import java.util.List;

import com.nano.todoapp.pojo.Todo;
import com.nano.todoapp.pojo.TxnStatus;

public interface TodoDAO {
	
	public List<Todo> getTodos();
	
	public Todo getTodo(int id);
	
	public TxnStatus addTodo(Todo todo);
	
	public TxnStatus deleteTodo(int todoId);
}
