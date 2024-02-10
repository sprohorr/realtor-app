package org.example.service;

import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.repository.RoleRepository;
import org.example.repository.UserRepository;
import org.example.util.TransformerDTOUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class UserService {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected TransformerDTOUser transformerDTOUser;

    @Autowired
    protected RoleRepository roleRepository;

    @Autowired
    protected PasswordEncoder passwordEncoder;

    public User saveUser(UserDTO userDTO) {
        org.example.entity.User user = new org.example.entity.User();
        user.setCreateTime(LocalDateTime.now());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(roleRepository.findByName("ROLE_USER"));
        return userRepository.save(transformerDTOUser
                .populateBeanFromDTO(user, userDTO));
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User findByLoginAndPassword(String login, String password) {
        User user = findByLogin(login);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) ;
        }
        return null;
    }

    public User findCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return findByLogin(auth.getName());
    }
}
