package ua.game.pro.dto;

public class KafkaMessage {
    private Integer id;
    private String text;
    private Integer groupId;

    public KafkaMessage(Integer id, String text, Integer groupId) {
        this.id = id;
        this.text = text;
        this.groupId = groupId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}
