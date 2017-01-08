package ua.game.pro.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;




@Entity
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private int phone;
	
	
	@ManyToOne
	private GroupOfUsers group;
	
	@OneToMany(mappedBy = "user")
	private List<FileUser> files;
	
	@Enumerated
	private Role role;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	



	public User(String name, String email, String password, int phone) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	

	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}




	public GroupOfUsers getGroup() {
		return group;
	}




	public void setGroup(GroupOfUsers group) {
		this.group = group;
	}




	public List<FileUser> getFiles() {
		return files;
	}




	public void setFiles(List<FileUser> files) {
		this.files = files;
	}




	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role.name()));
		return authorities;
	}


	public String getUsername() {
		
		return String.valueOf(id);
	}


	public boolean isAccountNonExpired() {
		
		return true;
	}


	public boolean isAccountNonLocked() {
		
		return true;
	}


	public boolean isCredentialsNonExpired() {
		
		return true;
	}


	public boolean isEnabled() {
		
		return true;
	}
	
}
