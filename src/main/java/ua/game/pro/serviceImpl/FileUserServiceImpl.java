package ua.game.pro.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ua.game.pro.dao.FileUserDao;
import ua.game.pro.dao.ProfesorDao;
import ua.game.pro.dao.UserDao;
import ua.game.pro.entity.FileUser;
import ua.game.pro.entity.User;
import ua.game.pro.service.FileUserService;
import ua.game.pro.service.KafkaService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class FileUserServiceImpl implements FileUserService {

    @Autowired
    private FileUserDao fileDao;
    @Autowired
    private ProfesorDao profesorDao;

    @Autowired
    private KafkaService kafkaService;
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
    public void saveFile(MultipartFile multipartFile, User user, int profesor) {

        resources.file.File file = new resources.file.File();

        FileUser fileUser = new FileUser(multipartFile.getOriginalFilename(), "resources/" + file.newFolder(user.getGroup().getId(), profesor, user.getId())
                + multipartFile.getOriginalFilename(), user, profesorDao.findOne(profesor));
        save(fileUser);

        String path = System.getProperty("catalina.home") + "/resources/"
                + file.newFolder(user.getGroup().getId(), profesor, user.getId())
                + multipartFile.getOriginalFilename();

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            multipartFile.transferTo(filePath);
            System.out.println("my tut");
            kafkaService.sendMessage(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }
    }


}
