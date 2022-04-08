package com.nano.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nano.todoapp.dao.TodoDAO;
import com.nano.todoapp.pojo.Todo;
import com.nano.todoapp.pojo.TxnStatus;

@Service
public class DefaultTodoService implements TodoService {
	
	@Autowired
	private TodoDAO todoDao;

	@Override
	public List<Todo> getTodos() {
		return todoDao.getTodos();
	}

	@Override
	public Todo getTodo(int id) {
		return todoDao.getTodo(id);
	}

	@Override
	public TxnStatus addTodo(Todo todo) {
		return todoDao.addTodo(todo);
	}
	
	@Override
	public TxnStatus deleteTodo(int todoId) {
		return todoDao.deleteTodo(todoId);
	}

	
}
