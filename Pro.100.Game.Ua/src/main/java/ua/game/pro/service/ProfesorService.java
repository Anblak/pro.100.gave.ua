package ua.game.pro.service;

import java.util.List;

import ua.game.pro.entity.GroupOfUsers;
import ua.game.pro.entity.Profesor;



public interface ProfesorService {
	
	void save(Profesor profesor);
	List<Profesor> findAll();
	Profesor findOne(int id);
	void delete(int id);
	
	Profesor findByName(String name);
	
}
