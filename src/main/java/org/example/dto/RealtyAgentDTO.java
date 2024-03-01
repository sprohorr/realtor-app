package org.example.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RealtyAgentDTO {

    private int id;

    @NotEmpty(message = "Name must not be empty!")
    @Size(min = 2, max = 20, message = "Enter min = 2, max = 20 symbols!")
    private String name;

    @NotEmpty(message = "Number phone must not be empty!")
    @Size(min = 13, message = "Input min 13 numbers!")
    private String tel;

    @NotEmpty(message = "Email must not be empty!")
    @Email(message = "Invalid!")
    private String email;

    @NotEmpty(message = "Address must not be empty!")
    private String address;

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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
