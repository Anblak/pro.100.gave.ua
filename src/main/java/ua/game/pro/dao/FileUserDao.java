package ua.game.pro.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.game.pro.entity.FileUser;

public interface FileUserDao extends JpaRepository<FileUser, Integer> {

}
