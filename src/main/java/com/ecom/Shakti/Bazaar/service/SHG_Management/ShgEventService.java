package com.ecom.Shakti.Bazaar.service.SHG_Management;

import com.ecom.Shakti.Bazaar.Enum.SHG_Management.ShgEventType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

@Service
@RequiredArgsConstructor
public class ShgEventService {

    private final DistrictService districtService;
    private final FederationService federationService;
    private final ShgService shgService;

    public String processEvent(String eventName,
                               ShgEventType eventType,
                               JsonNode data) {

        switch (eventType) {

            case DISTRICT:
                return districtService.handleEvent(eventName, data);

            case FEDERATION:
                return federationService.handleEvent(eventName, data);

            case SHG:
                return shgService.handleEvent(eventName, data);

            default:
                return "Unsupported SHG Event Type";
        }
    }
}
