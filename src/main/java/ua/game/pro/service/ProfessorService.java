package ua.game.pro.service;

import ua.game.pro.entity.Professor;

import java.util.List;


public interface ProfessorService {

    void save(Professor professor);

    List<Professor> findAll();

    Professor findOne(int id);

    void delete(int id);

    Professor findByName(String name);

}
