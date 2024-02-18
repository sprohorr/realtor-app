package org.example.dto;

import org.example.entity.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class UserDTO {

    private int id;

    @NotEmpty(message = "Name must not be empty!")
    @Size(min = 2, max = 20, message = "Enter min = 2, max = 20 symbols!")
    private String name;

    @NotEmpty(message = "Surname must not be empty!")
    @Size(min = 2, max = 20, message = "Enter min = 2, max = 20 symbols!")
    private String surname;

    @NotEmpty(message = "Email must not be empty!")
    @Email(message = "Invalid!")
    private String email;

    @NotEmpty(message = "Login must not be empty!")
    @Size(min = 4, message = "Enter min = 4 symbols!")
    private String login;

    @NotEmpty(message = "Password must not be empty!")
    @Size(min = 8, message = "Password must be min 8 symbols!")
    private String password;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Role role;

    public UserDTO() {
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
