package org.example.controllers;

import org.example.dto.UserDTO;
import org.example.entity.Apartment;
import org.example.entity.User;
import org.example.service.ApartmentService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    protected UserService userService;

    @Autowired
    protected ApartmentService apartmentService;

    @GetMapping("/mainpage")
    private String showMainPage() {
        return "/mainpage";
    }

    @GetMapping("/adminpage")
    public String showAdminPage(ModelMap modelMap) {
        modelMap.put("user", userService.findCurrentUser());
        return "/adminpage";
    }

    @GetMapping("/userreviewapartment")
    public String reviewApartments(@RequestParam("userId") int userId, ModelMap modelMap,
                                   @RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.by("building"));
        Page<Apartment> apartments = apartmentService.findAll(pageable);
        modelMap.addAttribute("apartments", apartments);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("totalpage", apartments.getTotalPages());
        modelMap.put("user", userService.findById(userId));
        return "/userreviewapartment";
    }

    @GetMapping("/registrationadmin")
    public String createAdmin(ModelMap modelMap) {
        modelMap.addAttribute("admin", new UserDTO());
        return "/registrationadmin";
    }

    @PostMapping("/registrationadmin")
    public String saveAdmin(@ModelAttribute("admin") @Valid UserDTO userDTO,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/registrationadmin";
        }
        if (userService.checkIfUserExistsByLogin(userDTO.getLogin())) {
            return "/usererror";
        } else {
            userService.saveAdmin(userDTO);
            return "redirect:/login";
        }
    }

    @GetMapping("/registration")
    public String createUser(ModelMap modelMap) {
        modelMap.addAttribute("user", new UserDTO());
        return "/registration";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user") @Valid UserDTO userDTO,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/registration";
        }
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
    public String saveEditUser(@RequestParam("userId") int id,
                               @ModelAttribute("user") @Valid UserDTO userDTO,
                               BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.put("user", userService.findById(id));
            return "/useredit";
        }
        userService.updateUser(userDTO, id);
        return "redirect:/usersuccess";
    }

    @GetMapping("/usererror")
    public String error() {
        return "/usererror";
    }

    @GetMapping("/usersuccess")
    public String successfully() {
        return "/usersuccess";
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
        return "redirect:/mainpage";
    }

    @GetMapping("/403")
    public String forbidden() {
        return "/403";
    }

}
