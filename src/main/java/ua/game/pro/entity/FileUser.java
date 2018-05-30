package ua.game.pro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FileUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	private String path;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Profesor profesor;
	
	public FileUser() {
		
	}

	public FileUser(String name, String path, User user, Profesor profesor) {
		super();
		this.name = name;
		this.path = path;
		this.user = user;
		this.profesor = profesor;
	}

	public FileUser(String name,  String path) {
		super();
		this.name = name;
	
		this.path = path;
	}

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
