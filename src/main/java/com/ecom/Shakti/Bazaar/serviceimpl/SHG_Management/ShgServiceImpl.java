package com.ecom.Shakti.Bazaar.serviceimpl.SHG_Management;

import com.ecom.Shakti.Bazaar.entity.SHG_Management.Federation;
import com.ecom.Shakti.Bazaar.entity.SHG_Management.SHG;
import com.ecom.Shakti.Bazaar.Enum.SHG_Management.SHGStatus;
import com.ecom.Shakti.Bazaar.repository.SHG_Management.FederationRepository;
import com.ecom.Shakti.Bazaar.repository.SHG_Management.ShgRepository;
import com.ecom.Shakti.Bazaar.service.SHG_Management.ShgService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

import java.time.LocalDate;

@Service   // THIS IS MANDATORY
@RequiredArgsConstructor
public class ShgServiceImpl implements ShgService {

    private final ShgRepository shgRepository;
    private final FederationRepository federationRepository;

    @Override
    public String handleEvent(String eventName, JsonNode data) {

        if ("CREATESHG".equalsIgnoreCase(eventName)) {

            // 1️⃣ Duplicate check
            String regNo = data.get("registrationNo").asText();
            if (shgRepository.existsByRegistrationNo(regNo)) {
                return "SHG already exists with this registration number";
            }

            // 2️⃣ Federation validation
            Long federationId = data.get("federationId").asLong();
            Federation federation = federationRepository.findById(federationId)
                    .orElseThrow(() -> new RuntimeException("Federation not found"));

            // 3️⃣ Create SHG
            SHG shg = SHG.builder()
                    .shgName(data.get("shgName").asText())
                    .registrationNo(regNo)
                    .dateOfRegistration(
                            LocalDate.parse(data.get("dateOfRegistration").asText())
                    )
                    .contactNumber(data.get("contactNumber").asText())
                    .address(data.get("address").asText())
                    .bankAccountNo(data.get("bankAccountNo").asText())
                    .ifscCode(data.get("ifscCode").asText())
                    .status(SHGStatus.ACTIVE)
                    .federation(federation)
                    .build();

            shgRepository.save(shg);
            return "SHG created successfully";
        }

        return "Unsupported SHG Event";
    }
}
