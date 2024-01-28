package org.example.util;

import org.example.dto.RealtyAgentDTO;
import org.example.entity.RealtyAgent;
import org.springframework.stereotype.Component;

@Component
public class TransformerDtoRealtyAgent {

    public RealtyAgent populateBeanFromDTO(RealtyAgent realtyAgent, RealtyAgentDTO realtyAgentDTO) {
        realtyAgent.setName(realtyAgentDTO.getName());
        realtyAgent.setTel(realtyAgentDTO.getTel());
        realtyAgent.setEmail(realtyAgentDTO.getEmail());
        realtyAgent.setAddress(realtyAgentDTO.getAddress());
        return realtyAgent;
    }

}
