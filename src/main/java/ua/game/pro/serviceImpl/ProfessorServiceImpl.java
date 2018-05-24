package ua.game.pro.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.game.pro.dao.ProfessorDao;
import ua.game.pro.entity.Professor;
import ua.game.pro.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService {
	
	@Autowired
	private ProfessorDao professorDao;
	


	@Override
	public void save(Professor professor){
		
		professorDao.save(professor);
		
	}

	@Override
	public List<Professor> findAll() {

		return professorDao.findAll();
	}

	@Override
	public Professor findOne(int id) {

		return professorDao.findOne(id);
	}

	@Override
	public void delete(int id) {

		professorDao.delete(id);

	}

	@Override
	public Professor findByName(String name) {
		return professorDao.findByName(name);
	}

}
