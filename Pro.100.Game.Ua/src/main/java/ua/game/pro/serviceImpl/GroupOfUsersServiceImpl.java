package ua.game.pro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.game.pro.dao.GroupOfUsersDao;
import ua.game.pro.entity.GroupOfUsers;
import ua.game.pro.service.GroupOfUsersService;

@Service
public class GroupOfUsersServiceImpl implements GroupOfUsersService {

	@Autowired
	private GroupOfUsersDao groupDao;

	@Override
	public void save(GroupOfUsers group) {
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
