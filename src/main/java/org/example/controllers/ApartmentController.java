package org.example.controllers;

import org.example.dto.ApartmentDTO;
import org.example.entity.Apartment;
import org.example.service.ApartmentService;
import org.example.service.BuildingService;
import org.example.service.RealtyAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/apartmentlist")
    public String showApartments(@RequestParam("agentId") int agentId, ModelMap modelMap,
                                 @RequestParam(defaultValue = "0") int page) {
        modelMap.put("agent", realtyAgentService.findRealtyAgentById(agentId));
        Pageable pageable = PageRequest.of(page, 5, Sort.by("building"));
        Page<Apartment> apartments = apartmentService.findAllApartmentsByRealtyAgent(agentId, pageable);
        modelMap.addAttribute("apartments", apartments);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("totalpage", apartments.getTotalPages());
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
                                    BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.put("apartment", apartmentService.findApartmentById(apartmentId));
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
