package org.example.restcontrollers;

import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.service.UserService;
import org.example.util.TransformerDTOUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    protected UserService userService;

    @Autowired
    protected TransformerDTOUser transformerDTOUser;

    @GetMapping("/")
    public String getUser() {
        return userService.findAll().toString();
    }

    @PostMapping("/")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        UserDTO userDTO = new UserDTO();
        transformerDTOUser.populateBeanFromDTO(user, userDTO);
        userService.saveUser(userDTO);
        return ResponseEntity.ok("create successfully!");
    }
}
