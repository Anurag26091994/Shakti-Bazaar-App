package com.ecom.Shakti.Bazaar.serviceimpl.Support_Document_Management;

import com.ecom.Shakti.Bazaar.service.Support_Document_Management.TicketService;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

@Service
public class TicketServiceImpl implements TicketService {

    @Override
    public String handleEvent(String eventName, JsonNode data) {
        switch (eventName.toUpperCase()) {
            case "CREATETICKET":
                return "Ticket Created";
            case "UPDATETICKET":
                return "Ticket Updated";
            case "GETTICKET":
                return "Ticket Retrieved";
            default:
                return "Unsupported Ticket Event";
        }
    }
}
