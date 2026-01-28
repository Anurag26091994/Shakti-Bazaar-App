package com.ecom.Shakti.Bazaar.service.Order_Payment_And_Delivery;

import java.util.Map;

public interface ShipmentTrackingService {
    String generateTrackingEvent(Map<String, Object> data);
    String updateTrackingEvent(Map<String, Object> data);
    String getTrackingEvent(Map<String, Object> data);
}
