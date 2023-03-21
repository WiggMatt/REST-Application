package REST.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import REST.entity.ToDoEntity;
import REST.entity.UserEntity;
import REST.model.ToDo;
import REST.repository.ToDoRepo;
import REST.repository.UserRepo;

@Service
public class ToDoService {

	@Autowired
	private ToDoRepo todoRepo;
	@Autowired
	private UserRepo userRepo;
	
	public ToDo createToDo(ToDoEntity todo, Long userId) {
		UserEntity user = userRepo.findById(userId).get();
		todo.setUser(user);
		return ToDo.toModel(todoRepo.save(todo));
	}
	
	public ToDo completeToDo(Long id) {
		ToDoEntity todo = todoRepo.findById(id).get();
		todo.setCompleted(todo.getCompleted());
		return ToDo.toModel(todoRepo.save(todo));
	}
}
