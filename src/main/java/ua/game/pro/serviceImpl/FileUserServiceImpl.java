package ua.game.pro.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ua.game.pro.dao.FileUserDao;
import ua.game.pro.dao.ProfesorDao;
import ua.game.pro.entity.FileUser;
import ua.game.pro.entity.User;
import ua.game.pro.service.FileUserService;
import ua.game.pro.service.KafkaService;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class FileUserServiceImpl implements FileUserService {

    @Autowired
    private FileUserDao fileDao;
    @Autowired
    private ProfesorDao profesorDao;

    @Autowired
    private KafkaService kafkaService;

    @Override
    public void save(FileUser file) {
        fileDao.save(file);
    }

    public List<FileUser> findAll(List<Integer> ids){
        return fileDao.findAll(ids);
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
        String uuid = UUID.randomUUID().toString();

        FileUser fileUser = new FileUser(multipartFile.getOriginalFilename(),
                "resources/" + file.newFolder(user.getGroup().getId(), profesor, user.getId()) +  uuid + "/"
                + multipartFile.getOriginalFilename(), user, profesorDao.findOne(profesor));
        save(fileUser);

        String path = System.getProperty("catalina.home") + "/resources/"
                + file.newFolder(user.getGroup().getId(), profesor, user.getId()) +  uuid + "/"
                + multipartFile.getOriginalFilename();


        File filePath = new File(path);
        try {
            filePath.mkdirs();
            multipartFile.transferTo(filePath);

        } catch (IOException e) {
            System.out.println("error with file");
        }

        try {
            if (multipartFile.getContentType()
                    .equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
                kafkaService.sendMessage(filePath, fileUser, user.getGroup().getId());
            }
        } catch (Exception e) {
            System.out.println("kafka problems");
            e.printStackTrace();
        }
    }


}
