package ua.game.pro.service;


import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.game.pro.entity.MusicFile;



public interface MusicFileService {
	
	void save(MusicFile musicFile);
	List<MusicFile> findAll();
	MusicFile findOne(int id);
	void delete(int id);
	
	public void saveImage(MultipartFile multipartFile);

}
