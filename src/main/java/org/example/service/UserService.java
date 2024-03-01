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
import java.util.List;


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

    public final static Integer ADMIN_ROLE = 1;
    public final static Integer USER_ROLE = 2;

    public User saveUser(UserDTO userDTO) {
        org.example.entity.User user = new org.example.entity.User();
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(roleRepository.findById(USER_ROLE).get());
        return userRepository.save(transformerDTOUser
                .populateBeanFromDTO(user, userDTO));
    }

    public User saveAdmin(UserDTO userDTO) {
        User user = new User();
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setRole(roleRepository.findById(ADMIN_ROLE).get());
        return userRepository.save(transformerDTOUser
                .populateBeanFromDTO(user, userDTO));
    }

    public User updateUser(UserDTO userDTO, int id) {
        User user = userRepository.findById(id).get();
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setEmail(userDTO.getEmail());
        user.setUpdateTime(LocalDateTime.now());
        user.setLogin(user.getLogin());
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }

    public boolean checkIfUserExistsByLogin(String login) {
        return userRepository.existsUserByLogin(login);
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User findCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return findByLogin(auth.getName());
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }
}
