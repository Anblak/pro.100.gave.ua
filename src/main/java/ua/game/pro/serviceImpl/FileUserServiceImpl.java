package ua.game.pro.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ua.game.pro.dao.FileUserDao;
import ua.game.pro.dao.ProfessorDao;
import ua.game.pro.dao.UserDao;
import ua.game.pro.entity.FileUser;
import ua.game.pro.entity.GroupOfUsers;
import ua.game.pro.service.FileUserService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class FileUserServiceImpl implements FileUserService {

    @Autowired
    private FileUserDao fileDao;

    @Autowired
    private ProfessorDao professorDao;

    @Autowired
    private UserDao userDao;

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
    public void saveFile(MultipartFile multipartFile, GroupOfUsers groupOfUsers, int profesor) {


        String path = "resources/" + groupOfUsers.getId() + "/"
                + multipartFile.getOriginalFilename();

        File filePath = new File(System.getProperty("catalina.home") + "/" + path);

        try {
            filePath.mkdirs();
            multipartFile.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }

        FileUser fileUser = new FileUser(multipartFile.getOriginalFilename(), path, professorDao.findOne(profesor));
        save(fileUser);
    }

}
