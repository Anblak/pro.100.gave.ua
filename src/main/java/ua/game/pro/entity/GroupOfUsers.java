package ua.game.pro.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class GroupOfUsers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String uuid;
	
	@OneToMany(mappedBy = "group")
	private List<User> users;
	
	@OneToMany(mappedBy = "groupOfUsers")
	private List<Profesor> profesors;
	
	public GroupOfUsers() {
		// TODO Auto-generated constructor stub
	}

	public GroupOfUsers(String name) {
		super();
		this.name = name;
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Profesor> getProfesors() {
		return profesors;
	}

	public void setProfesors(List<Profesor> profesors) {
		this.profesors = profesors;
	}
	
	
	
	
	
}
