package com.nano.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nano.todoapp.pojo.CustomException;
import com.nano.todoapp.pojo.Todo;
import com.nano.todoapp.pojo.TxnStatus;
import com.nano.todoapp.service.TodoService;

@RequestMapping("/todo-app")
@RestController
public class RootController {
	
	@Autowired
	private TodoService todoService;
	
	@GetMapping("/todos")
	public List<Todo> getTodos(){
		return todoService.getTodos();
	}
	
	@GetMapping("/todo/{id}")
	public Todo getTodo(@PathVariable int id) throws CustomException {
		return todoService.getTodo(id);
	}
	
	@PostMapping("/todo")
	public TxnStatus addTodo(@RequestBody Todo todo) throws CustomException {
		return todoService.addTodo(todo);
	}
	
	@DeleteMapping("/todo/{id}")
	public TxnStatus deleteTodo(@PathVariable int id) throws CustomException {
		return todoService.deleteTodo(id);
	}
}
