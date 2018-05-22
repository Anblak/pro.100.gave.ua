package ua.game.pro.service;

import java.util.List;

import ua.game.pro.entity.GroupOfUsers;
import ua.game.pro.entity.User;


public interface GroupOfUsersService {
	
	
	void save(GroupOfUsers group,User user)throws Exception;
	List<GroupOfUsers> findAll();
	GroupOfUsers findOne(int id);
	void delete(int id,User user);
	
//	GroupOfUsers findByUUID(String uuid,User user);
	GroupOfUsers findByUUID(String uuid);
	
}
