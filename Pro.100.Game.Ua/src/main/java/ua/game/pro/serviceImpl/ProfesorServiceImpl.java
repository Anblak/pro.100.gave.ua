package ua.game.pro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.game.pro.dao.GroupOfUsersDao;
import ua.game.pro.dao.ProfesorDao;
import ua.game.pro.entity.GroupOfUsers;
import ua.game.pro.entity.Profesor;
import ua.game.pro.service.ProfesorService;

@Service
public class ProfesorServiceImpl implements ProfesorService {
	
	@Autowired
	private ProfesorDao profesorDao;
	


	@Override
	public void save(Profesor profesor){
		
		profesorDao.save(profesor);
		
	}

	@Override
	public List<Profesor> findAll() {

		return profesorDao.findAll();
	}

	@Override
	public Profesor findOne(int id) {

		return profesorDao.findOne(id);
	}

	@Override
	public void delete(int id) {

		profesorDao.delete(id);

	}

	@Override
	public Profesor findByName(String name) {	
		return profesorDao.findByName(name);
	}

}
