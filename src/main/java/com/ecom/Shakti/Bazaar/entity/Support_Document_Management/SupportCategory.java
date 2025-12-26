package com.ecom.Shakti.Bazaar.entity.Support_Document_Management;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "support_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupportCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(nullable = false, unique = true)
    private String name;   // it can be Payment, Delivery, Product

    @Column(name = "sla_hours", nullable = false)
    private Integer slaHours;
}
