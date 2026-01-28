package com.ecom.Shakti.Bazaar.entity.Order_Payment_And_Delivery;

import com.ecom.Shakti.Bazaar.Enum.Order_Payment_And_Delivery.DeliveryStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "shipments")
@Getter
@Setter
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shipmentId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "delivery_partner_id")
    private DeliveryPartner deliveryPartner;

    private LocalDate shippedDate;

    private LocalDate expectedDelivery;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
}

