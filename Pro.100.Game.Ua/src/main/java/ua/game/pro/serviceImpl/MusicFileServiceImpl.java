package ua.game.pro.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ua.game.pro.dao.MusicFileDao;
import ua.game.pro.entity.MusicFile;
import ua.game.pro.service.MusicFileService;

@Service
public class MusicFileServiceImpl implements MusicFileService{

	@Autowired
	private MusicFileDao musicFileDao; 
	
	
	@Override
	public void save(MusicFile musicFile) {
		musicFileDao.save(musicFile);
		
	}

	@Override
	public List<MusicFile> findAll() {
		
		return musicFileDao.findAll();
	}

	@Override
	public MusicFile findOne(int id) {
		
		return musicFileDao.findOne(id);
	}

	@Override
	public void delete(int id) {
		
		musicFileDao.delete(id);
	}

	@Override
	public void saveImage(MultipartFile multipartFile) {
		MusicFile musicFile= new MusicFile();
		String path = System.getProperty("catalina.home") + "/resources/img/"+ multipartFile.getOriginalFilename();
		musicFile.setPath("resources/img/" + multipartFile.getOriginalFilename());
		File file=new File(path);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			
		} catch (IOException e) {
			
		}
		
	}

}
