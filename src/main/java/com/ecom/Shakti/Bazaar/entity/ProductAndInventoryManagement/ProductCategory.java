package com.ecom.Shakti.Bazaar.entity.ProductAndInventoryManagement;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Entity
@Table(
        name = "product_category",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "name")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @NotBlank(message = "Category name is required")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", length = 1000)
    private String description;

    // MANY categories → ONE Business Plan
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_plan_id")
    private BusinessPlan businessPlan;

    // MANY categories → ONE Marketing Plan
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marketing_plan_id")
    private MarketingPlan marketingPlan;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products;

}
