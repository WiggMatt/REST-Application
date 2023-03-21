package REST.model;

import REST.entity.ToDoEntity;

public class ToDo {
	private Long id;
	private String titlte;
	private Boolean completed;
	
	public static ToDo toModel(ToDoEntity entity) {
		ToDo model = new ToDo();
		model.setId(entity.getId());
		model.setTitlte(entity.getTitle());
		model.setCompleted(entity.getCompleted());
		return model;
	}
	
	public ToDo() {}

	public String getTitlte() {
		return titlte;
	}

	public void setTitlte(String titlte) {
		this.titlte = titlte;
	}

	public Boolean getCompleted() {
		return completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
