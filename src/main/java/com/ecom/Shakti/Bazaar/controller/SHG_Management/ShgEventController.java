package com.ecom.Shakti.Bazaar.controller.SHG_Management;

import com.ecom.Shakti.Bazaar.dto.SHG_Management.ShgEventRequest;
import com.ecom.Shakti.Bazaar.service.SHG_Management.ShgEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shg/events")
@CrossOrigin("*")
@RequiredArgsConstructor
public class ShgEventController
{

   private final ShgEventService shgEventService;

    @PostMapping("/trigger")
    public ResponseEntity<String> triggerEvent(
            @RequestBody ShgEventRequest request)
    {

        if (!request.getFlag())
        {
            return ResponseEntity.ok("Flag false, event ignored");
        }

        return ResponseEntity.ok
                (
                shgEventService.processEvent(
                        request.getEventName(),
                        request.getEventType(),
                        request.getData()
                )
        );
    }
}
