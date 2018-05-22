package ua.game.pro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.game.pro.entity.Profesor;


public interface ProfesorDao extends JpaRepository<Profesor, Integer> {
	Profesor findByName(String name);
}
