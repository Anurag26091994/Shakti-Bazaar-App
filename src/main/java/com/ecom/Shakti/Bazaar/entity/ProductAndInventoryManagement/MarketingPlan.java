package com.ecom.Shakti.Bazaar.entity.ProductAndInventoryManagement;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "marketing_plan")
@Getter
@Setter
public class MarketingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long marketingPlanId;

    private String planName;
}

