package REST.repository;

import org.springframework.data.repository.CrudRepository;

import REST.entity.ToDoEntity;

public interface ToDoRepo extends CrudRepository<ToDoEntity, Long>{
}
