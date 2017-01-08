package ua.game.pro.service;

import java.util.List;

import ua.game.pro.entity.GroupOfUsers;


public interface GroupOfUsersService {
	
	
	void save(GroupOfUsers group)throws Exception;
	List<GroupOfUsers> findAll();
	GroupOfUsers findOne(int id);
	void delete(int id);
	
	
}
