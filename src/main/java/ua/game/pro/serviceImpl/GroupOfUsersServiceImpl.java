package ua.game.pro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.game.pro.dao.GroupOfUsersDao;
import ua.game.pro.dao.UserDao;
import ua.game.pro.entity.GroupOfUsers;
import ua.game.pro.entity.Role;
import ua.game.pro.entity.User;
import ua.game.pro.service.GroupOfUsersService;
import ua.game.pro.validator.Validator;

@Service
public class GroupOfUsersServiceImpl implements GroupOfUsersService {

	@Autowired
	private GroupOfUsersDao groupDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	@Qualifier("GroupOfUsersValidator")
	private Validator validator;
	
	@Override
	public void save(GroupOfUsers group,User user) throws Exception {
		validator.validate(group);
		user.setRole(Role.ROLE_CREATOR);
		groupDao.save(group);
		user.setGroup(group);
		userDao.save(user);
	}

	@Override
	public List<GroupOfUsers> findAll() {

		return groupDao.findAll();
	}
	
	@Override
	public GroupOfUsers findOne(int id) {

		return groupDao.findOne(id);
	}
	
	@Override
	public void delete(int id,User user) {
		user.setRole(Role.ROLE_USER);
		groupDao.delete(id);
		userDao.save(user);

	}

//	@Override
//	public GroupOfUsers findByUUID(String uuid,User user) {
//		
//		userDao.save(user);
//		return groupDao.findByUUID(uuid);
//	}
	
	@Override
	public GroupOfUsers findByUUID(String uuid) {
		
		return groupDao.findByUUID(uuid);
	}

}
