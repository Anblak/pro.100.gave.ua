package ua.game.pro.service;

import org.springframework.web.multipart.MultipartFile;
import ua.game.pro.entity.FileUser;
import ua.game.pro.entity.GroupOfUsers;

import java.util.List;


public interface FileUserService {

    void save(FileUser file);

    List<FileUser> findAll();

    FileUser findOne(int id);

    void delete(int id);

    void saveFile(MultipartFile multipartFile, GroupOfUsers groupOfUsers, int profesor);


}
