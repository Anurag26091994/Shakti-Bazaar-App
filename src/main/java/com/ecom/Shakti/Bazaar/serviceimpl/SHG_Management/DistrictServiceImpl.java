package com.ecom.Shakti.Bazaar.serviceimpl.SHG_Management;

import com.ecom.Shakti.Bazaar.entity.SHG_Management.District;
import com.ecom.Shakti.Bazaar.repository.SHG_Management.DistrictRepository;
import com.ecom.Shakti.Bazaar.service.SHG_Management.DistrictService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

@Service
@RequiredArgsConstructor
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;


    @Override
    public String handleEvent(String eventName, JsonNode data) {

        if ("CREATEDISTRICT".equalsIgnoreCase(eventName)) {

            District district = District.builder()
                    .name(data.get("name").asText())
                    .state(data.get("state").asText())
                    .regionCode(data.get("regionCode").asText())
                    .build();

            districtRepository.save(district);
            return "District created successfully";
        }

        return "Unsupported District Event";
    }
}
