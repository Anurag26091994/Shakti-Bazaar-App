package com.ecom.Shakti.Bazaar.entity.ProductAndInventoryManagement;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SOP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sop_id")
    private Long sopId;

    @NotBlank(message = "SOP title is required")
    @Column(name = "title", nullable = false)
    private String title;

    @NotBlank(message = "Document URL is required")
    @Column(name = "document_url", length = 500)
    private String documentUrl;

    @PastOrPresent(message = "Effective date cannot be in the future")
    @Column(name = "effective_date")
    private LocalDate effectiveDate;

    @OneToMany(mappedBy = "sop", fetch = FetchType.LAZY)
    private List<Product> products;

}

