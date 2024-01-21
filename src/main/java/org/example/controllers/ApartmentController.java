package org.example.controllers;

import org.example.dto.ApartmentDTO;
import org.example.service.ApartmentService;
import org.example.service.RealtyAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ApartmentController {

    @Autowired
    protected ApartmentService apartmentService;

    @Autowired
    protected RealtyAgentService realtyAgentService;

    @GetMapping("/apartmentlist")
    public String showApartments(@RequestParam("agent.id") int agentId, ModelMap modelMap) {
        modelMap.put("agent", realtyAgentService.findRealtyAgentById(agentId));
        modelMap.put("apartments", apartmentService.findAllApartmentsByRealtyAgent(agentId));
        return "/apartmentlist";
    }

    @GetMapping("/apartmentadd")
    public String addApartment(@RequestParam("agent.id") int agentId, ModelMap modelMap) {
        modelMap.put("agent", realtyAgentService.findRealtyAgentById(agentId));
        modelMap.addAttribute("apartment", new ApartmentDTO());
        return "/apartmentadd";
    }

    @PostMapping("/apartmentadd")
    public String saveApartment(@RequestParam("agent.id") int agentId, ModelMap modelMap, ApartmentDTO apartmentDTO) {
        modelMap.put("apartment", apartmentService.saveApartment(agentId, apartmentDTO));
        return "redirect:/agentlist";
    }

    @GetMapping("/apartmentedit")
    public String editApartment(@RequestParam("apartment.id") int apartmentId, ModelMap modelMap) {
        modelMap.addAttribute("apartment", new ApartmentDTO());
        modelMap.put("apartment", apartmentService.findApartmentById(apartmentId));
        return "/apartmentedit";
    }

    @PostMapping("/apartmentedit")
    public String saveEditApartment(@RequestParam("apartment.id") int apartmentId, ModelMap modelMap, ApartmentDTO apartmentDTO) {
        modelMap.put("apartment", apartmentService.editApartment(apartmentId, apartmentDTO));
        return "redirect:/agentlist";
    }
}
