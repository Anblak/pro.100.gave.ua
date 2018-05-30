package ua.game.pro.service;


import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.File;

public interface KafkaService {

    void sendMessage(File file) throws JsonProcessingException;

}
