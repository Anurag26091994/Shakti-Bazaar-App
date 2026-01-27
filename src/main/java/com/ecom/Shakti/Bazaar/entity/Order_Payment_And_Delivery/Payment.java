package com.ecom.Shakti.Bazaar.entity.Order_Payment_And_Delivery;

import com.ecom.Shakti.Bazaar.Enum.Order_Payment_And_Delivery.PaymentMode;
import com.ecom.Shakti.Bazaar.Enum.Order_Payment_And_Delivery.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", nullable = false)
    private Transaction transaction;



    private LocalDateTime paymentDate;
}

