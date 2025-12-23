package com.ecom.Shakti.Bazaar.entity.ProductAndInventoryManagement;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(
        name = "traceability_record",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "batch_no")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TraceabilityRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "traceability_id")
    private Long traceabilityId;

    @NotBlank(message = "Batch number is required")
    @Column(name = "batch_no", nullable = false, unique = true)
    private String batchNo;

    @PastOrPresent(message = "Production date cannot be in the future")
    @Column(name = "production_date", nullable = false)
    private LocalDate productionDate;

    @Column(name = "inspection_details", length = 1000)
    private String inspectionDetails;

    @Column(name = "location_history", length = 2000)
    private String locationHistory;

    @OneToMany(mappedBy = "traceability")
    private List<Product> products;
}

