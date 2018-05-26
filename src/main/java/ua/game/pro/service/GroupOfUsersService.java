package ua.game.pro.service;

import ua.game.pro.entity.GroupOfUsers;
import ua.game.pro.entity.User;

import java.util.List;


public interface GroupOfUsersService {


    void save(GroupOfUsers group, User user) throws Exception;

    List<GroupOfUsers> findAll();

    GroupOfUsers findOne(int id);

    void delete(int id, User user);

    //	GroupOfUsers findByUuid(String uuid,User user);
    GroupOfUsers findByUUID(String uuid);

}
