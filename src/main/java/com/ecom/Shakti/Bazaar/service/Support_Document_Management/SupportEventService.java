package com.ecom.Shakti.Bazaar.service.Support_Document_Management;

import com.ecom.Shakti.Bazaar.Enum.Support_Document_Management.SupportEventType;
import com.ecom.Shakti.Bazaar.util.FormLogger;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;


@Service
public class SupportEventService {

    private final DocumentService documentService;
    private final AuditLogService auditLogService;
    private final TicketService ticketService;
    private final SupportCategoryService supportCategoryService;

    public SupportEventService(DocumentService documentService,
                               AuditLogService auditLogService,
                               TicketService ticketService,
                               SupportCategoryService supportCategoryService) {
        this.documentService = documentService;
        this.auditLogService = auditLogService;
        this.ticketService = ticketService;
        this.supportCategoryService = supportCategoryService;
    }

    public String processEvent(String eventName,
                               SupportEventType eventType,
                               JsonNode data,
                               Boolean flag) {

        FormLogger.info("Support EventService called: " + eventType);

        if (!flag) {
            return "Flag is false, event not processed";
        }

        switch (eventType) {

            case DOCUMENT:
                return documentService.handleEvent(eventName, data);

            case AUDIT_LOG:
                return auditLogService.handleEvent(eventName, data);

            case TICKET:
                return ticketService.handleEvent(eventName, data);

            case SUPPORT_CATEGORY:
                return supportCategoryService.handleEvent(eventName, data);

            default:
                return "Unsupported Event Type";
        }
    }
}
