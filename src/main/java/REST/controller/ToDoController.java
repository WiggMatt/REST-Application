package REST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import REST.entity.ToDoEntity;
import REST.service.ToDoService;

@RestController
@RequestMapping("/todos")
public class ToDoController {
	
	@Autowired
	private ToDoService todoService;
	
	@PostMapping
	public ResponseEntity<Object> createToDo(@RequestBody ToDoEntity todo,
									 @RequestParam Long userId) {
		try {
			return ResponseEntity.ok(todoService.createToDo(todo, userId));
		} catch (Exception c) {
			return ResponseEntity.badRequest().body("Произошла ошибка");
		}
	}
	
	@PutMapping
	public ResponseEntity<Object> completeToDo(@RequestParam Long id) {
		try {
			return ResponseEntity.ok(todoService.completeToDo(id));

		} catch (Exception c) {
			return ResponseEntity.badRequest().body("Произошла ошибка");
		}
	}
}
