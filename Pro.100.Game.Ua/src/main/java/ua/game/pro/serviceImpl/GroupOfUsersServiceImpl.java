package ua.game.pro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ua.game.pro.dao.GroupOfUsersDao;
import ua.game.pro.entity.GroupOfUsers;
import ua.game.pro.service.GroupOfUsersService;
import ua.game.pro.validator.Validator;

@Service
public class GroupOfUsersServiceImpl implements GroupOfUsersService {

	@Autowired
	private GroupOfUsersDao groupDao;
	
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;

	@Override
	public void save(GroupOfUsers group) throws Exception {
		validator.validate(group);
		groupDao.save(group);
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
	public void delete(int id) {

		groupDao.delete(id);

	}

}
