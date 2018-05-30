package ua.game.pro.service;

import org.springframework.web.multipart.MultipartFile;
import ua.game.pro.entity.FileUser;
import ua.game.pro.entity.User;

import java.util.List;


public interface FileUserService {

    void save(FileUser file);

    List<FileUser> findAll();

    List<FileUser> findAll(List<Integer> ids);

    FileUser findOne(int id);

    void delete(int id);

    void saveFile(MultipartFile multipartFile, User user, int profesor);


}
