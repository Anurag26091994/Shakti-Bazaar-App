package com.ecom.Shakti.Bazaar.serviceimpl.Order_Payment_And_Delivery;

import com.ecom.Shakti.Bazaar.service.Order_Payment_And_Delivery.PaymentService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public String handlePaymentEvent(String eventName, Map<String, Object> data) {

        switch (eventName) {

            case "INITIATE_PAYMENT":
                return "PAYMENT_INITIATED";

            case "CONFIRM_PAYMENT":
                return "PAYMENT_SUCCESS";

            case "REFUND_PAYMENT":
                return "PAYMENT_REFUNDED";

            default:
                return "UNKNOWN_PAYMENT_EVENT";
        }
    }
}

