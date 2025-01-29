package org.example.controllers;

import org.example.dto.RealtyAgentDTO;
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
public class RealtyAgentController {

    @Autowired
    protected RealtyAgentService realtyAgentService;

    @GetMapping("/agentadd")
    public String addAgent(ModelMap modelMap) {
        modelMap.addAttribute("agent", new RealtyAgentDTO());
        return "/agentadd";
    }

    @PostMapping("/agentadd")
    public String createAgent(@ModelAttribute("agent") @Valid RealtyAgentDTO realtyAgentDTO,
                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/agentadd";
        }
        if (realtyAgentService.checkIfRealtyAgentExistsByName(realtyAgentDTO.getName())) {
            return "/agenterror";
        } else {
            realtyAgentService.saveRealtyAgent(realtyAgentDTO);
            return "redirect:/agentsuccess";
        }
    }

    @GetMapping("/agentlist")
    public String showListAgent(ModelMap modelMap) {
        modelMap.put("agent", realtyAgentService.findAll());
        return "/agentlist";
    }

    @GetMapping("/agentsuccess")
    public String successfully() {
        return "/agentsuccess";
    }

    @GetMapping("/agenterror")
    public String error() {
        return "/agenterror";
    }

    @GetMapping("/agentedit")
    public String editAgent(@RequestParam("agentId") int id, ModelMap modelMap) {
        modelMap.addAttribute("agent", new RealtyAgentDTO());
        modelMap.put("agent", realtyAgentService.findRealtyAgentById(id));
        return "/agentedit";
    }

    @PostMapping("/agentedit")
    public String saveEditAgent(@RequestParam("agentId") int id,
                                @ModelAttribute("agent") @Valid RealtyAgentDTO realtyAgentDTO,
                                BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            modelMap.put("agent", realtyAgentService.findRealtyAgentById(id));
            return "/agentedit";
        }
        realtyAgentService.editAgent(id, realtyAgentDTO);
        return "redirect:/agentlist";

    }

    @GetMapping("/agentpage")
    public String showAccountPage(@RequestParam("agentId") int id, ModelMap modelMap) {
        modelMap.put("agent", realtyAgentService.findRealtyAgentById(id));
        return "agentpage";
    }
}
