package com.ecom.Shakti.Bazaar.dto.Order_Payment_And_Delivery;

import com.ecom.Shakti.Bazaar.Enum.Order_Payment_And_Delivery.OrderEventType;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class OrderEventRequest {

    private String eventName;
    private String eventType;
    private Boolean flag;
    private Map<String, Object> data;

    // getters & setters
}

