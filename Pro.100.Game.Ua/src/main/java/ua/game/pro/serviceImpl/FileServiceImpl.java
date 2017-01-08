package ua.game.pro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.game.pro.dao.FileDao;
import ua.game.pro.entity.File;
import ua.game.pro.service.FileService;

@Service
public class FileServiceImpl implements FileService{
	
	@Autowired
	private FileDao fileDao;

	@Override
	public void save(File file) {
		fileDao.save(file);
	}

	@Override
	public List<File> findAll() {

		return fileDao.findAll();
	}

	@Override
	public File findOne(int id) {

		return fileDao.findOne(id);
	}

	@Override
	public void delete(int id) {

		fileDao.delete(id);

	}

}
