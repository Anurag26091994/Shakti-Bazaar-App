package com.ecom.Shakti.Bazaar.controller.Order_Payment_And_Delivery;

import com.ecom.Shakti.Bazaar.Enum.Order_Payment_And_Delivery.OrderEventType;
import com.ecom.Shakti.Bazaar.dto.Order_Payment_And_Delivery.OrderEventRequest;
import com.ecom.Shakti.Bazaar.serviceimpl.Order_Payment_And_Delivery.OrderEventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/order-event")
@CrossOrigin("*")
public class OrderEventController {

    private final OrderEventService eventService;

    public OrderEventController(OrderEventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/process")
    public ResponseEntity<String> processEvent(
            @RequestBody Map<String, Object> request
    ) {

        String eventName = (String) request.get("eventName");
        String eventTypeStr = (String) request.get("eventType");
        Boolean flag = request.get("flag") == null ? true : (Boolean) request.get("flag");
        Map<String, Object> data = (Map<String, Object>) request.get("data");

        OrderEventType eventType = OrderEventType.valueOf(eventTypeStr);

        return ResponseEntity.ok(
                eventService.processOrderEvent(eventName, eventType, data, flag)
        );
    }
}



