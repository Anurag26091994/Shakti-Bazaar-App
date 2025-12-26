package com.ecom.Shakti.Bazaar.controller.Support_Document_Management;
import com.ecom.Shakti.Bazaar.dto.Support_Document_Management.SupportEventRequest;
import com.ecom.Shakti.Bazaar.service.Support_Document_Management.SupportEventService;
import com.ecom.Shakti.Bazaar.util.FormLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/support/events")
@CrossOrigin("*")
public class SupportEventController {

    @Autowired
    private SupportEventService supportEventService;

    @PostMapping("/trigger")
    public ResponseEntity<String> triggerEvent(@RequestBody SupportEventRequest data) {
        FormLogger.info("Support EventController triggered: " + data.toString());
        try {
            String response = supportEventService.processEvent(
                    data.getEventName(),
                    data.getEventType(),
                    data.getData(),
                    data.getFlag()
            );
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            FormLogger.error("Support EventController Error: " + e.getMessage());
            return ResponseEntity.status(500).body("Error processing support event");
        }
    }
}
