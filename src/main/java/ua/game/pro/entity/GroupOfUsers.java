package ua.game.pro.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class GroupOfUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String uuid;

    @OneToMany(mappedBy = "group")
    private List<User> users;

    @OneToMany(mappedBy = "groupOfUsers")
    private List<Professor> professors;

    @OneToMany(mappedBy = "groupOfUsers")
    private List<FileUser> fileUsers;

    public GroupOfUsers() {
    }

    public GroupOfUsers(String name) {
        super();
        this.name = name;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }


    public List<FileUser> getFileUsers() {
        return fileUsers;
    }

    public void setFileUsers(List<FileUser> fileUsers) {
        this.fileUsers = fileUsers;
    }
}
