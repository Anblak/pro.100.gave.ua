package ua.game.pro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MusicFile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String pathMusic;
	
	private String name;
	
	public MusicFile() {
		// TODO Auto-generated constructor stub
	}

	public MusicFile(String path, String name) {
		super();
		this.pathMusic = path;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return pathMusic;
	}

	public void setPath(String path) {
		this.pathMusic = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
