package com.ecom.Shakti.Bazaar.service.Support_Document_Management;

import tools.jackson.databind.JsonNode;

public interface TicketService {
    String handleEvent(String eventName, JsonNode data);
}
