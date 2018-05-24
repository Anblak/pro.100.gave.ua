package ua.game.pro.dto;


import ua.game.pro.entity.Professor;
import ua.game.pro.entity.User;

public class FileUserDTO {

    private int id;
    private String name;
    private String path;
    private User user;
    private Professor professor;

    public FileUserDTO() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


}
