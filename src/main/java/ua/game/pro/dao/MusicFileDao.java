package ua.game.pro.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import ua.game.pro.entity.MusicFile;

public interface MusicFileDao extends JpaRepository<MusicFile,Integer>{

}
