package com.ecom.Shakti.Bazaar.serviceimpl.SHG_Management;

import com.ecom.Shakti.Bazaar.entity.SHG_Management.District;
import com.ecom.Shakti.Bazaar.entity.SHG_Management.Federation;
import com.ecom.Shakti.Bazaar.repository.SHG_Management.DistrictRepository;
import com.ecom.Shakti.Bazaar.repository.SHG_Management.FederationRepository;
import com.ecom.Shakti.Bazaar.service.SHG_Management.FederationService;
import tools.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service   // 🔥 THIS IS MANDATORY
@RequiredArgsConstructor
public class FederationServiceImpl implements FederationService {

    private final FederationRepository federationRepository;
    private final DistrictRepository districtRepository;

    @Override
    public String handleEvent(String eventName, JsonNode data) {

        if ("CREATEFEDERATION".equalsIgnoreCase(eventName)) {

            Long districtId = data.get("districtId").asLong();

            District district = districtRepository.findById(districtId)
                    .orElseThrow(() -> new RuntimeException("District not found"));

            Federation federation = Federation.builder()
                    .name(data.get("name").asText())
                    .email(data.get("email").asText())
                    .phone(data.get("phone").asText())
                    .contactPerson(data.get("contactPerson").asText())
                    .district(district)
                    .build();

            federationRepository.save(federation);
            return "Federation created successfully";
        }

        return "Unsupported Federation Event";
    }
}
