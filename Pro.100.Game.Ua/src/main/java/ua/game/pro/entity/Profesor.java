package ua.game.pro.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Entity
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int price;
	
	@OneToMany(mappedBy = "profesor")
	private List<FileUser> files;
	
	@ManyToOne
	private GroupOfUsers groupOfUsers;
	
	@ManyToMany
	@JoinTable(name = "user_profesor", joinColumns = @JoinColumn(name = "profesor_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users;
	
	public Profesor() {
	
	}

	public Profesor(String name) {
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

	public List<FileUser> getFiles() {
		return files;
	}

	public void setFiles(List<FileUser> files) {
		this.files = files;
	}

	public GroupOfUsers getGroupOfUsers() {
		return groupOfUsers;
	}

	public void setGroupOfUsers(GroupOfUsers groupOfUsers) {
		this.groupOfUsers = groupOfUsers;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
