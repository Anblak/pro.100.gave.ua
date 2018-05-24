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
	private Professor professor;

    @ManyToOne
    private GroupOfUsers groupOfUsers;
	
	public FileUser() {
		
	}

	public FileUser(String name, String path, Professor professor) {
		this.name = name;
		this.path = path;
		this.professor = professor;
	}
}
