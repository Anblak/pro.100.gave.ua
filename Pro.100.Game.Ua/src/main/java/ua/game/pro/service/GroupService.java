package ua.game.pro.service;

import java.util.List;

import ua.game.pro.entity.Group;


public interface GroupService {
	
	
	void save(Group group);
	List<Group> findAll();
	Group findOne(int id);
	void delete(int id);
	
	
}
