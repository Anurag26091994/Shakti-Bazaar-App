package com.ecom.Shakti.Bazaar.service.SHG_Management;


import tools.jackson.databind.JsonNode;

public interface ShgService {
    String handleEvent(String eventName, JsonNode data);
}
