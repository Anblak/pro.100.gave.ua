package ua.game.pro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.game.pro.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{
	
	User findByName(String name);

}
