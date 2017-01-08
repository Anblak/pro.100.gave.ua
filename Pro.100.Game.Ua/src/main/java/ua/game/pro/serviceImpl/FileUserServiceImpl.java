package ua.game.pro.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import ua.game.pro.dao.FileUserDao;
import ua.game.pro.entity.FileUser;
import ua.game.pro.entity.User;
import ua.game.pro.service.FileUserService;

@Service
public class FileUserServiceImpl implements FileUserService {

	@Autowired
	private FileUserDao fileDao;

	@Override
	public void save(FileUser file) {
		fileDao.save(file);
	}

	@Override
	public List<FileUser> findAll() {

		return fileDao.findAll();
	}

	@Override
	public FileUser findOne(int id) {

		return fileDao.findOne(id);
	}

	@Override
	public void delete(int id) {

		fileDao.delete(id);

	}

	@Transactional
	public void saveFile(MultipartFile multipartFile, User users, int profesor) {

		resources.file.File file = new resources.file.File();

		FileUser fileUser = new FileUser(multipartFile.getOriginalFilename(),
				"resources/" + file.newFolder(users.getGroup().getId(), profesor, users.getId())
						+ multipartFile.getOriginalFilename());

		save(fileUser);

		String path = System.getProperty("catalina.home") + "/resources/"
				+ file.newFolder(users.getGroup().getId(), profesor, users.getId())
				+ multipartFile.getOriginalFilename();

		File filePath = new File(path);

		try {
			filePath.mkdirs();
			try {
				FileUtils.cleanDirectory(new File(System.getProperty("catalina.home") + "/resources/"
						+ file.newFolder(users.getGroup().getId(), profesor, users.getId())));
			} catch (IOException e) {
				e.printStackTrace();
			}
			multipartFile.transferTo(filePath);
		} catch (IOException e) {
			System.out.println("error with file");
		}
	}

}
