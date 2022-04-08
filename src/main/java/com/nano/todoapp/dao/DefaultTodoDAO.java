package com.nano.todoapp.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.nano.todoapp.pojo.CustomException;
import com.nano.todoapp.pojo.Todo;
import com.nano.todoapp.pojo.TxnStatus;

@Repository
public class DefaultTodoDAO implements TodoDAO {
	
	private List<Todo> todos = new ArrayList<>(
			Arrays.asList(
					new Todo(1, "Code java", new Date()),
					new Todo(2, "Code HTML", new Date()),
					new Todo(3, "Design UI", new Date()),
					new Todo(4, "Design DB", new Date()),
					new Todo(5, "Implement DB", new Date()),
					new Todo(6, "Code Postgresql", new Date()),
					new Todo(7, "DB Connections", new Date()),
					new Todo(8, "Code React", new Date()),
					new Todo(9, "Code Axios", new Date())
				)
			);

	@Override
	public List<Todo> getTodos() {
		todos.sort((a,b) -> {
			if(a.getId() - b.getId() > 0) return 1;
			else if(a.getId() == b.getId()) return 0;
			else return -1;
		});
		return todos;
	}

	@Override
	public Todo getTodo(int id) {
		List<Todo> todo = todos.stream().filter(t -> t.getId()==id).collect(Collectors.toList());
		if(todo.size() == 0) throw new CustomException("Todo not found!", 401, HttpStatus.BAD_REQUEST);
		return todo.get(0);
	}

	@Override
	public TxnStatus addTodo(Todo todo) {
		int todoId = 1;
		for(Todo t : todos) {
			if(todo.getTitle().equals(t.getTitle())) throw new CustomException("Todo with same title already exists!", 401 , HttpStatus.BAD_REQUEST);
			if(t.getId() != todoId) break;
			todoId++;
		}
		todo.setId(todoId);
		todos.add(todo);
		todos.sort((a,b) -> {
			if(a.getId() - b.getId() > 0) return 1;
			else if(a.getId() == b.getId()) return 0;
			else return -1;
		});
		
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", "Todo added succesfullly!");
		response.put("data", todo);
		response.put("statusCd", 200);
		response.put("status", HttpStatus.OK);
		return new TxnStatus(response, 200, HttpStatus.OK);
	}
	
	@Override
	public TxnStatus deleteTodo(int todoId) {
		todoId--;
		if(todoId >= todos.size() || todoId <= 1) throw new CustomException("Todo does not exists!", 401, HttpStatus.BAD_REQUEST);
		Todo todo = todos.get(todoId);
		todos.remove(todoId);
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("message", "Todo deleted succesfullly!");
		response.put("data", todo);
		response.put("statusCd", 200);
		response.put("status", HttpStatus.OK);
		return new TxnStatus(response, 200, HttpStatus.OK);
	}

}
