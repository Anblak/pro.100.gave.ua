package ua.game.pro.dto;

public class UserDTO {
    private int id;
    private String name;
    private String email;
    private int phone;

    private String role;

    public UserDTO() {
    }


    public int getPhone() {
        return phone;
    }


    public void setPhone(int phone) {
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", role='" + role + '\'' +
                '}';
    }
}
