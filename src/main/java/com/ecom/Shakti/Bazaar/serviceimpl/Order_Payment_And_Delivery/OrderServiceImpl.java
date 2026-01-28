package com.ecom.Shakti.Bazaar.serviceimpl.Order_Payment_And_Delivery;

import com.ecom.Shakti.Bazaar.service.Order_Payment_And_Delivery.OrderService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public String handleOrderEvent(String eventName, Map<String, Object> data) {

        switch (eventName) {

            case "PLACE_ORDER":
                return placeOrder(data);

            case "CANCEL_ORDER":
                return cancelOrder(data);

            default:
                return "UNKNOWN_ORDER_EVENT";
        }
    }

    private String placeOrder(Map<String, Object> data) {
        Long userId = Long.valueOf(data.get("userId").toString());
        Double amount = Double.valueOf(data.get("amount").toString());

        // 🔹 Save Order entity
        // order.setCustomerId(userId);

        return "ORDER_PLACED_SUCCESSFULLY";
    }

    private String cancelOrder(Map<String, Object> data) {
        return "ORDER_CANCELLED";
    }
}

