package com.ecom.Shakti.Bazaar.serviceimpl.Order_Payment_And_Delivery;

import com.ecom.Shakti.Bazaar.service.Order_Payment_And_Delivery.ShipmentService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Override
    public String handleShipmentEvent(String eventName, Map<String, Object> data) {

        switch (eventName) {

            case "CREATE_SHIPMENT":
                return "SHIPMENT_CREATED";

            case "DISPATCH_SHIPMENT":
                return "SHIPMENT_DISPATCHED";

            case "DELIVER_SHIPMENT":
                return "SHIPMENT_DELIVERED";

            default:
                return "UNKNOWN_SHIPMENT_EVENT";
        }
    }
}

