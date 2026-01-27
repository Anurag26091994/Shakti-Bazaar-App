package com.ecom.Shakti.Bazaar.entity.Order_Payment_And_Delivery;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private Double amount;

    private String referenceNo;

    private String status;

    private LocalDateTime createdAt;

//    @OneToOne(mappedBy = "transaction")
//    private Payment payments;
}
