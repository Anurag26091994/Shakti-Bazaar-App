package com.ecom.Shakti.Bazaar.serviceimpl.Order_Payment_And_Delivery;

import com.ecom.Shakti.Bazaar.Enum.Order_Payment_And_Delivery.OrderEventType;
import com.ecom.Shakti.Bazaar.service.Order_Payment_And_Delivery.OrderService;
import com.ecom.Shakti.Bazaar.service.Order_Payment_And_Delivery.PaymentService;
import com.ecom.Shakti.Bazaar.service.Order_Payment_And_Delivery.ShipmentService;
import com.ecom.Shakti.Bazaar.util.FormLogger;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderEventService {

    private final OrderService orderService;
    private final PaymentService paymentService;
    private final ShipmentService shipmentService;

    public OrderEventService(OrderService orderService,
                             PaymentService paymentService,
                             ShipmentService shipmentService) {
        this.orderService = orderService;
        this.paymentService = paymentService;
        this.shipmentService = shipmentService;
    }

    public String processOrderEvent(String eventName,
                                    OrderEventType eventType,
                                    Map<String, Object> data,
                                    Boolean flag) {

        if (Boolean.FALSE.equals(flag)) {
            return "EVENT_SKIPPED";
        }

        switch (eventType) {
            case ORDER:
                return orderService.handleOrderEvent(eventName, data);

            case PAYMENT:
                return paymentService.handlePaymentEvent(eventName, data);

            case SHIPMENT:
                return shipmentService.handleShipmentEvent(eventName, data);

            default:
                return "UNSUPPORTED_EVENT_TYPE";
        }
    }
}



