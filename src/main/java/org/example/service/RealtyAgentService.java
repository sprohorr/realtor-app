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
        return realtyAgentRepository
                .save(transformerDtoRealtyAgent.saveTransformDtoRealtyAgent(realtyAgentDTO));
    }

    public List<RealtyAgent> findAll() {
        return realtyAgentRepository.findAll();
    }

    public RealtyAgent findRealtyAgentById(int id) {
        return realtyAgentRepository.findRealtyAgentById(id);
    }

    public RealtyAgent editAgent(int id, RealtyAgentDTO realtyAgentDTO) {
        return realtyAgentRepository.save(transformerDtoRealtyAgent
                .editTransformDtoRealtyAgent(findRealtyAgentById(id), realtyAgentDTO));
    }
}
