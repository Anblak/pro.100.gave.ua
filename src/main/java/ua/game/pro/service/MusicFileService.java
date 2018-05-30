package ua.game.pro.service;


import org.springframework.web.multipart.MultipartFile;
import ua.game.pro.entity.MusicFile;

import java.util.List;


public interface MusicFileService {

    void save(MusicFile musicFile);

    List<MusicFile> findAll();

    MusicFile findOne(int id);

    void delete(int id);

    void saveMusic(MultipartFile multipartFile);

}
