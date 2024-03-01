package org.example.service;

import org.example.dto.RealtyAgentDTO;
import org.example.entity.RealtyAgent;
import org.example.repository.RealtyAgentRepository;
import org.example.util.TransformerDtoRealtyAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RealtyAgentService {

    @Autowired
    protected TransformerDtoRealtyAgent transformerDtoRealtyAgent;

    @Autowired
    protected RealtyAgentRepository realtyAgentRepository;

    public RealtyAgent saveRealtyAgent(RealtyAgentDTO realtyAgentDTO) {
        RealtyAgent realtyAgent = new RealtyAgent();
        return realtyAgentRepository
                .save(transformerDtoRealtyAgent.populateBeanFromDTO(realtyAgent, realtyAgentDTO));
    }

    public boolean checkIfRealtyAgentExistsByName(String name) {
        return realtyAgentRepository.existsRealtyAgentByName(name);
    }

    public List<RealtyAgent> findAll() {
        return realtyAgentRepository.findAll();
    }

    public RealtyAgent findRealtyAgentById(int id) {
        return realtyAgentRepository.findById(id).orElse(null);
    }

    public RealtyAgent editAgent(int agentId, RealtyAgentDTO realtyAgentDTO) {
        return realtyAgentRepository.save(transformerDtoRealtyAgent
                .populateBeanFromDTO(realtyAgentRepository.findById(agentId).get(), realtyAgentDTO));
    }

    public RealtyAgent findRealtyAgentByName(String name) {
        return realtyAgentRepository.findRealtyAgentByName(name);
    }
}
