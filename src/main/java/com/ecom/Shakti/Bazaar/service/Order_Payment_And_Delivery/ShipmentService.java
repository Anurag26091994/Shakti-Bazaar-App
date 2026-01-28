package com.ecom.Shakti.Bazaar.service.Order_Payment_And_Delivery;

import java.util.Map;

public interface ShipmentService {
    String handleShipmentEvent(String eventName, Map<String, Object> data);
}


