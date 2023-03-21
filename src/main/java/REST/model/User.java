package REST.model;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import REST.entity.UserEntity;

public class User {
	private Long id;
	private String username;
	private List<ToDo> todos;
	
	public static User toModel(UserEntity entity) {
		User model = new User();
		model.setId(entity.getId());
		model.setUsername(entity.getUsername());
		model.setTodos(entity.getTodos().stream().map(ToDo::toModel).collect(Collectors.toList()));
		return model;
	}
	
	public User() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<ToDo> getTodos() {
		return todos;
	}

	public void setTodos(List<ToDo> todos) {
		this.todos = todos;
	}
	
	
}
