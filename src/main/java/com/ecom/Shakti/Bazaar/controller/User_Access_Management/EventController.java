package com.ecom.Shakti.Bazaar.controller.User_Access_Management;

import com.ecom.Shakti.Bazaar.dto.User_Access_Management.EventRequest;
import com.ecom.Shakti.Bazaar.serviceimpl.User_Access_Management.EventService;
import com.ecom.Shakti.Bazaar.util.FormLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
@CrossOrigin("*")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/trigger")
    public ResponseEntity<String> triggerEvent(@RequestBody EventRequest data) {
        FormLogger.info("EventController: triggerEvent called with eventName: " + data.getEventName() +
                ", eventType: " + data.getEventType() + ", flag: " + data.getFlag());
        try {

            String response = eventService.processEvent(data.getEventName(), data.getEventType(),
                    data.getData(), data.getFlag());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            FormLogger.error("EventController: Error in triggerEvent - " + e.getMessage());
            return ResponseEntity.status(500).body("Error processing event: " + e.getMessage());
        }
    }
}
