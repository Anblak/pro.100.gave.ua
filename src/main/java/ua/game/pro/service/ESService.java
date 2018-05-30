package ua.game.pro.service;

import java.util.List;
import ua.game.pro.entity.FileUser;

public interface ESService {
    List<FileUser> findFiles(String searchText, Integer groupId);
}
