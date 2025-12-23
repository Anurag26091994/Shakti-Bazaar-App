package com.ecom.Shakti.Bazaar.entity.ProductAndInventoryManagement;


import com.ecom.Shakti.Bazaar.Enum.ProductAndInventoryManagement.ProductStatus;
import com.ecom.Shakti.Bazaar.entity.Order_Payment_And_DeliveryModule.OrderItem;
import com.ecom.Shakti.Bazaar.entity.SHG_Management.SHG;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @NotBlank(message = "Product name is required")
    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "description", length = 1000)
    private String description;

    @Positive(message = "Price must be greater than zero")
    @Column(name = "price", nullable = false)
    private Double price;

    // ---------- FK MAPPINGS ----------

    // MANY products → ONE SHG
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shg_id", nullable = false)
    private SHG shg;

    // MANY products → ONE category
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    // MANY products → ONE SOP
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sop_id")
    private SOP sop;

    // MANY products → ONE Quality Certificate
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quality_certificate_id")
    private QualityCertificate qualityCertificate;

    // MANY products → ONE Traceability
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "traceability_id")
    private TraceabilityRecord  traceability;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Inventory> inventories;


    // ---------- PRODUCT DETAILS ----------

    @Min(value = 0, message = "Stock cannot be negative")
    @Column(name = "stock")
    private Integer stock;

    @Enumerated(EnumType.STRING)
    @Column(name = "status",nullable = false)
    private ProductStatus status;

    @PrePersist
    public void prePersist() {
        if (this.status == null) {
            // Default when product is newly created
            this.status = ProductStatus.IN_REVIEW;
        }

        if (this.stock == null) {
            this.stock = 0;
        }

        if (this.stock == 0) {
            this.status = ProductStatus.OUT_OF_STOCK;
        }
    }
}

