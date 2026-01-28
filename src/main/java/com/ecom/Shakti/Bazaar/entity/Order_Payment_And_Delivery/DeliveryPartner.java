package com.ecom.Shakti.Bazaar.entity.Order_Payment_And_Delivery;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "delivery_partners")
@Getter @Setter
public class DeliveryPartner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryPartnerId;

    private String partnerName;

    private String contactNumber;

    private String serviceArea;
}

