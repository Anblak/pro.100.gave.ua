package ua.game.pro.service;

import java.util.List;

import ua.game.pro.entity.File;



public interface FileService {
	void save(File file);
	List<File> findAll();
	File findOne(int id);
	void delete(int id);
}
