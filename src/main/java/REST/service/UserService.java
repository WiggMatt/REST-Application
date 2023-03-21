package REST.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import REST.entity.UserEntity;
import REST.exception.UserAlreadyExistException;
import REST.exception.UserNotFoundException;
import REST.model.User;
import REST.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	
	public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
		if(userRepo.findByUsername(user.getUsername()) != null) {
			throw new UserAlreadyExistException("Пользователь с таким именем уже существует!"); 
		}
		return userRepo.save(user);
	}
	
	public User getOneUser(Long id) throws UserNotFoundException {
		UserEntity user = userRepo.findById(id).get();
		if(user == null) {
			throw new UserNotFoundException("Пользователь не найден!");
		}
		return User.toModel(user);
	}
	
	public Long deleteUser(Long id) {
		userRepo.deleteById(id);
		return id;
	}
	
}
