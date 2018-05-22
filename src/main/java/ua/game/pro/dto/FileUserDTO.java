package ua.game.pro.dto;



import ua.game.pro.entity.Profesor;
import ua.game.pro.entity.User;

public class FileUserDTO {

	private int id;
	private String name;
	private String path;
	private User user;
	private Profesor profesor;
	
	public FileUserDTO(){}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	
	
	
}
