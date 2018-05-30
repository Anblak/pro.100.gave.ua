package ua.game.pro.service;

import ua.game.pro.entity.Profesor;

import java.util.List;


public interface ProfesorService {

    void save(Profesor profesor);

    List<Profesor> findAll();

    Profesor findOne(int id);

    void delete(int id);

    Profesor findByName(String name);

}
