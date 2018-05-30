package ua.game.pro.dto;

public class KafkaMessage {
    private Long id;
    private String text;
    private Long groupId;

    public KafkaMessage(Long id, String text, Long groupId) {
        this.id = id;
        this.text = text;
        this.groupId = groupId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}
