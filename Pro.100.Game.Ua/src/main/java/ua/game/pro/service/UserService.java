package ua.game.pro.service;

import java.util.List;

import ua.game.pro.entity.GroupOfUsers;
import ua.game.pro.entity.User;



public interface UserService {
	
	void save(User user) throws Exception;
	List<User> findAll();
	User findOne(int id);
	void delete(int id);
	
	void update(User user,GroupOfUsers group);
	
}
