package ua.game.pro.serviceImpl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.io.Resources;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import ua.game.pro.dto.KafkaMessage;
import ua.game.pro.service.KafkaService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class KafkaServiceImpl implements KafkaService {
    private static final String TOPIC = "summertime";
    private KafkaProducer<String, String> producer;
    private ObjectMapper objectMapper;

    public KafkaServiceImpl() throws IOException {
        try (InputStream props = Resources.getResource("producer.props").openStream()) {
            Properties properties = new Properties();
            properties.load(props);
            producer = new KafkaProducer<>(properties);
        }
        objectMapper = new ObjectMapper();
    }

    @Override
    public void sendMessage(File file) throws JsonProcessingException {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(file.getAbsolutePath())) {
            XWPFDocument document = new XWPFDocument(fis);
            for (XWPFParagraph xwpfParagraph :
                    document.getParagraphs()) {
                stringBuilder.append(xwpfParagraph.getText());
                stringBuilder.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            producer.send(new ProducerRecord<>(TOPIC, objectMapper
                    .writeValueAsString(new KafkaMessage(1L, stringBuilder.toString(), 1L))));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
