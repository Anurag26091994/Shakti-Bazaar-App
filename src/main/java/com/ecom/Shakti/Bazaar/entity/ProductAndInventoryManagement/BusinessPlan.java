package com.ecom.Shakti.Bazaar.entity.ProductAndInventoryManagement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "business_plan")
@Getter
@Setter
public class BusinessPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long businessPlanId;

    private String planName;
}

