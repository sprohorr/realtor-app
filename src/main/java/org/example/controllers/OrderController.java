package org.example.controllers;

import org.example.entity.OrderUser;
import org.example.service.ApartmentService;
import org.example.service.OrderService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderController {

    @Autowired
    protected OrderService orderService;

    @Autowired
    protected UserService userService;

    @Autowired
    protected ApartmentService apartmentService;

    @GetMapping("/ordermake")
    public String createOrder(@RequestParam("userId") int userId,
                              @RequestParam("apartmentId") int apartmentId, ModelMap modelMap) {
        modelMap.addAttribute("order", new OrderUser());
        modelMap.put("user", userService.findById(userId));
        modelMap.put("apartment", apartmentService.findApartmentById(apartmentId));
        return "/ordermake";
    }

    //check
    @PostMapping("/ordermake")
    public String saveOrder(@RequestParam("userId") int userId,
                            @RequestParam("apartmentId") int apartmentId, OrderUser order,
                            RedirectAttributes attributes) {
        orderService.saveOrder(userId, apartmentId, order);
        attributes.addAttribute("user", userService.findById(userId));
        return "redirect:/userreviewapartment";
    }

    //check!
    @GetMapping("/order")
    public ModelAndView showOrder(@RequestParam("userId") int userId, ModelAndView model) {
        model.addObject("user", userService.findById(userId));
        model.setViewName("/order");
        String text = "No order found for this user!";

        if (orderService.findAllByUser(userId).isEmpty()) {
            model.addObject("orders", orderService.findAllByUser(userId));
        } else {
            model.addObject("text", text);
        }
        return model;
    }

    @GetMapping("/ordererror")
    public String showError() {
        return "/ordererror";
    }
}
