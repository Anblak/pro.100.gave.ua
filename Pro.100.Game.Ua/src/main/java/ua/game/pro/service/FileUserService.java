package ua.game.pro.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.game.pro.entity.FileUser;



public interface FileUserService {
	
	void save(FileUser file);
	List<FileUser> findAll();
	FileUser findOne(int id);
	void delete(int id);
	
	public void saveFile(MultipartFile multipartFile,int group,int profesor,int user);
	
}
