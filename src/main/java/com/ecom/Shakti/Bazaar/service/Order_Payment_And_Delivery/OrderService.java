package com.ecom.Shakti.Bazaar.service.Order_Payment_And_Delivery;

import java.util.Map;

public interface OrderService {
    String handleOrderEvent(String eventName, Map<String, Object> data);
}
