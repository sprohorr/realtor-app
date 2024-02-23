package org.example.controllers;

import org.example.dto.ApartmentDTO;
import org.example.service.ApartmentService;
import org.example.service.BuildingService;
import org.example.service.RealtyAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class ApartmentController {

    @Autowired
    protected ApartmentService apartmentService;

    @Autowired
    protected RealtyAgentService realtyAgentService;

    @Autowired
    protected BuildingService buildingService;

    @GetMapping("/userreviewapartment")
    public String reviewApartment(ModelMap modelMap) {
        modelMap.put("apartments", apartmentService.findAll());
        return "/userreviewapartment";
    }

    @GetMapping("/apartmentlist")
    public String showApartments(@RequestParam("agentId") int agentId, ModelMap modelMap) {
        modelMap.put("agent", realtyAgentService.findRealtyAgentById(agentId));
        modelMap.put("apartments", apartmentService.findAllApartmentsByRealtyAgent(agentId));
        return "/apartmentlist";
    }

    @GetMapping("/apartmentadd")
    public String addApartment(@RequestParam("buildingId") int buildingId, ModelMap modelMap) {
        modelMap.addAttribute("apartment", new ApartmentDTO());
        modelMap.put("building", buildingService.findBuildingById(buildingId));
        modelMap.put("listagent", realtyAgentService.findAll());
        return "/apartmentadd";
    }

    @PostMapping("/apartmentadd")
    public String saveApartment(@RequestParam("buildingId") int buildingId,
                                @ModelAttribute("apartment")
                                @Valid ApartmentDTO apartmentDTO,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/apartmentadd";
        }
        if (apartmentService.checkIfApartmentByBuildingIdAndNumber(buildingId, apartmentDTO.getNumber())) {
            return "/apartmenterror";
        } else {
            apartmentService.saveApartment(buildingId, apartmentDTO);
            return "redirect:/apartmentsuccess";
        }
    }

    @GetMapping("/apartmentedit")
    public String editApartment(@RequestParam("apartmentId") int apartmentId, ModelMap modelMap) {
        modelMap.addAttribute("apartment", new ApartmentDTO());
        modelMap.put("apartment", apartmentService.findApartmentById(apartmentId));
        modelMap.put("listagent", realtyAgentService.findAll());
        modelMap.put("listbuilding", buildingService.findAllBuilding());
        return "/apartmentedit";
    }

    @PostMapping("/apartmentedit")
    public String saveEditApartment(@RequestParam("apartmentId") int apartmentId,
                                    @ModelAttribute("apartment")
                                    @Valid ApartmentDTO apartmentDTO,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/apartmentedit";
        }
        if (apartmentService.checkIfApartmentByBuildingIdAndNumber(apartmentDTO.getBuilding().getId(), apartmentDTO.getNumber())) {
            return "/apartmenterror";
        } else {
            apartmentService.editApartment(apartmentId, apartmentDTO);
            return "redirect:/agentlist";
        }
    }

    @GetMapping("/apartmentsuccess")
    public String successfully() {
        return "/apartmentsuccess";
    }

    @GetMapping("/apartmenterror")
    public String error() {
        return "/apartmenterror";
    }
}
