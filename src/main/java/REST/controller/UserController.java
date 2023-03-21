package REST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import REST.entity.UserEntity;
import REST.exception.UserAlreadyExistException;
import REST.exception.UserNotFoundException;
import REST.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
  
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<String> registration(@RequestBody UserEntity user) {
		try {
			userService.registration(user);
		  return ResponseEntity.ok("Пользователь успешно сохранен!");
		} catch (UserAlreadyExistException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		catch (Exception c) {
		  return ResponseEntity.badRequest().body("Произошла ошибка");
		}
	}
	
  @GetMapping
  public ResponseEntity<Object> getOneUser (@RequestParam Long id) {
    try {
      return ResponseEntity.ok(userService.getOneUser(id));
    } catch (UserNotFoundException e) {
    	return ResponseEntity.badRequest().body(e.getMessage());
    } 
    catch (Exception c) {
      return ResponseEntity.badRequest().body("Произошла ошибка");
    }
  }
  
  @DeleteMapping("/{id}")
	public ResponseEntity deleteUser(@PathVariable Long id) {
	  try {
	      return ResponseEntity.ok(userService.deleteUser(id));
	    } 
	    catch (Exception c) {
	      return ResponseEntity.badRequest().body("Произошла ошибка");
	    }
  }
}