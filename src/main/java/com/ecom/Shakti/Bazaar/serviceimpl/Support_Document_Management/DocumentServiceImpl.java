package com.ecom.Shakti.Bazaar.serviceimpl.Support_Document_Management;

import com.ecom.Shakti.Bazaar.service.Support_Document_Management.DocumentService;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Override
    public String handleEvent(String eventName, JsonNode data) {
        switch (eventName.toUpperCase()) {
            case "UPLOADDOCUMENT":
                return "Document Uploaded";
            case "GETDOCUMENT":
                return "Document Retrieved";
            default:
                return "Unsupported Document Event";
        }
    }
}
