package org.example.dto;

import org.example.entity.Role;

import java.time.LocalDateTime;
import java.util.Objects;

public class UserDTO {

    private int id;

    private String name;

    private String surname;

    private String email;

    private String login;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return id == userDTO.id && Objects.equals(name, userDTO.name) && Objects.equals(surname, userDTO.surname) && Objects.equals(email, userDTO.email) && Objects.equals(login, userDTO.login) && Objects.equals(password, userDTO.password) && Objects.equals(createTime, userDTO.createTime) && Objects.equals(updateTime, userDTO.updateTime) && Objects.equals(role, userDTO.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, login, password, createTime, updateTime, role);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", role=" + role +
                '}';
    }
}
