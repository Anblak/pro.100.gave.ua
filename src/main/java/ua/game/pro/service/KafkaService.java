package ua.game.pro.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import ua.game.pro.entity.FileUser;

import java.io.File;

public interface KafkaService {

    void sendMessage(File file, FileUser fileUser, Integer groupId) throws JsonProcessingException;

}
