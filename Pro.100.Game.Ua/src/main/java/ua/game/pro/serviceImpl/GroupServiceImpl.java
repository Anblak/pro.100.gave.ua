package ua.game.pro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.game.pro.dao.GroupDao;
import ua.game.pro.entity.Group;
import ua.game.pro.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService {

	@Autowired
	private GroupDao groupDao;

	@Override
	public void save(Group group) {
		groupDao.save(group);
	}

	@Override
	public List<Group> findAll() {

		return groupDao.findAll();
	}

	@Override
	public Group findOne(int id) {

		return groupDao.findOne(id);
	}

	@Override
	public void delete(int id) {

		groupDao.delete(id);

	}

}
