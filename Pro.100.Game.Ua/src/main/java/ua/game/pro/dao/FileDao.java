package ua.game.pro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.game.pro.entity.File;

public interface FileDao extends JpaRepository<File, Integer> {

}
