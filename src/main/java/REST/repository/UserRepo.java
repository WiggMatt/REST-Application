package REST.repository;

import org.springframework.data.repository.CrudRepository;

import REST.entity.UserEntity;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
	UserEntity findByUsername(String username); 
}
