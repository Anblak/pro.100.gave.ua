package ua.game.pro.dto;

import ua.game.pro.entity.GroupOfUsers;

public class ProfessorDTO {
    private int id;
    private String name;

    private GroupOfUsers groupOfUsers;

    public ProfessorDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GroupOfUsers getGroupOfUsers() {
        return groupOfUsers;
    }

    public void setGroupOfUsers(GroupOfUsers groupOfUsers) {
        this.groupOfUsers = groupOfUsers;
    }


}
