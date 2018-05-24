package ua.game.pro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.game.pro.entity.Professor;


public interface ProfessorDao extends JpaRepository<Professor, Integer> {
	Professor findByName(String name);
}
