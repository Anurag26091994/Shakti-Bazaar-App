package com.ecom.Shakti.Bazaar.serviceimpl.Support_Document_Management;

import com.ecom.Shakti.Bazaar.service.Support_Document_Management.AuditLogService;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    @Override
    public String handleEvent(String eventName, JsonNode data) {
        if ("CREATEAUDIT".equalsIgnoreCase(eventName)) {
            return "Audit Log Created";
        }
        return "Unsupported Audit Event";
    }
}
