package ua.game.pro.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(mappedBy = "profesor")
	private List<FileUser> files;
	
	@ManyToOne
	private GroupOfUsers groupOfUsers;
	
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
	
	

}
