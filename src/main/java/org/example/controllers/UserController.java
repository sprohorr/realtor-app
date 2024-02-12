package org.example.controllers;

import org.example.dto.UserDTO;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    protected UserService userService;

    @GetMapping("/mainpage")
    private String showMainPage() {
        return "/mainpage";
    }

    @GetMapping("/adminpage")
    public String showAdminPage() {
        return "/adminpage";
    }

    @GetMapping("/usererror")
    public String error() {
        return "/usererror";
    }

    @GetMapping("/usersuccess")
    public String successfully() {
        return "/usersuccess";
    }

    @GetMapping("/registration")
    public String createUser(ModelMap modelMap) {
        modelMap.addAttribute("user", new UserDTO());
        return "/registration";
    }

    @PostMapping("/registration")
    public String saveUser(UserDTO userDTO) {
        if (userService.checkIfUserExistsByLogin(userDTO.getLogin())) {
            return "/usererror";
        } else {
            userService.saveUser(userDTO);
            return "redirect:/login";
        }
    }

    @GetMapping("/useredit")
    public String editUser(@RequestParam("userId") int id, ModelMap modelMap) {
        modelMap.addAttribute("user", new UserDTO());
        modelMap.put("user", userService.findById(id));
        return "/useredit";
    }

    @PostMapping("/useredit")
    public String saveEditUser(@RequestParam("userId") int id, UserDTO userDTO) {
        userService.updateUser(userDTO, id);
        return "redirect:/usersuccess";
    }

    @GetMapping("/login")
    public String login(ModelMap modelMap) {
        modelMap.addAttribute("login", new User());
        return "/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "/mainpage";
    }

    @GetMapping("/userpage")
    public String showClientPage(ModelMap modelMap) {
        modelMap.put("user", userService.findCurrentUser());
        return "/userpage";
    }

    @GetMapping("/userlist")
    public String showClientsList(ModelMap modelMap) {
        modelMap.put("users", userService.findAll());
        return "/userlist";
    }
}
