package org.example.controllers;

import org.example.dto.RealtyAgentDTO;
import org.example.service.RealtyAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String createAgent(ModelMap modelMap, RealtyAgentDTO realtyAgentDTO) {
        modelMap.put("agent", realtyAgentService.saveRealtyAgent(realtyAgentDTO));
        return "redirect:/agentsuccess";
    }

    @GetMapping("/agentlist")
    public String showListAgent(ModelMap modelMap) {
        modelMap.put("agent", realtyAgentService.findAll());
        return "/agentlist";
    }

    @GetMapping("/agentsuccess")
    public String showSuccess() {
        return "/agentsuccess";
    }

    @GetMapping("/agentedit")
    public String editAgent(@RequestParam("agent.id") int id, ModelMap modelMap) {
        modelMap.addAttribute("agent", new RealtyAgentDTO());
        modelMap.put("agent", realtyAgentService.findRealtyAgentById(id));
        return "/agentedit";
    }

    @PostMapping("/agentedit")
    public String saveEditAgent(@RequestParam("agent.id") int id, RealtyAgentDTO realtyAgentDTO) {
        realtyAgentService.editAgent(id, realtyAgentDTO);
        return "redirect:/agentlist";
    }

    @GetMapping("/agentaccountpage")
    public String showAccountPage(@RequestParam("agent.id") int id, ModelMap modelMap) {
        modelMap.put("agent", realtyAgentService.findRealtyAgentById(id));
        return "/agentaccountpage";
    }
}
