package ua.game.pro.service;

import java.security.Principal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.game.pro.entity.GroupOfUsers;
import ua.game.pro.entity.User;
import ua.game.pro.entity.enums.Role;

public interface UserService {

	void save(User user) throws Exception;

	List<User> findAll();

	User findOne(int id);

	void delete(int id);

	void update(User user, GroupOfUsers group);

	void updateUser(User user);

	User findByUUID(String uuid);

	void updatePassword(User user);

	void saveImage(Principal principal, MultipartFile multipartFile);

}
