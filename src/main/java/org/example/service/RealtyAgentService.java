package org.example.service;

import org.example.dto.RealtyAgentDTO;
import org.example.entity.RealtyAgent;
import org.example.repository.RealtyAgentRepository;
import org.example.util.TransformerDtoRealtyAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<RealtyAgent> findAll() {
        return realtyAgentRepository.findAll();
    }

    public Optional<RealtyAgent> findRealtyAgentById(int id) {
        return Optional.ofNullable(realtyAgentRepository.findById(id).orElse(null));
    }

    public Optional<RealtyAgent> editAgent(int id, RealtyAgentDTO realtyAgentDTO) {
        return Optional.of(realtyAgentRepository.save(transformerDtoRealtyAgent
                .populateBeanFromDTO(realtyAgentRepository.findById(id).orElse(null), realtyAgentDTO)));
    }
}
