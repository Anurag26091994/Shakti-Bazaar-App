package com.ecom.Shakti.Bazaar.service.SHG_Management;

import tools.jackson.databind.JsonNode;

public interface DistrictService {
    String handleEvent(String eventName, JsonNode data);
}
