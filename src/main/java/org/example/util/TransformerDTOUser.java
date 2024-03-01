package org.example.util;

import org.example.dto.UserDTO;
import org.example.entity.User;
import org.springframework.stereotype.Component;

@Component
public class TransformerDTOUser {

    public User populateBeanFromDTO(User user, UserDTO userDTO) {
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setLogin(userDTO.getLogin());
        return user;
    }

}
