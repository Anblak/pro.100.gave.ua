//package ua.game.pro.entity;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//
//
//
//@Entity
//public class Group {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	
//	private String name;
//	private String uuid;
//	
//	@OneToMany(mappedBy = "group")
//	private List<User> user;
//	
//	public Group() {}
//
//	public Group(String name) {
//		super();
//		this.name = name;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public List<User> getUser() {
//		return user;
//	}
//
//	public void setUser(List<User> user) {
//		this.user = user;
//	}
//
//	public String getUuid() {
//		return uuid;
//	}
//
//	public void setUuid(String uuid) {
//		this.uuid = uuid;
//	}
//	
//	
//	
//}
