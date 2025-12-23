package com.ecom.Shakti.Bazaar.entity.ProductAndInventoryManagement;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "quality_certificate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QualityCertificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quality_certificate_id")
    private Long qualityCertificateId;

    @NotBlank(message = "Certificate name is required")
    @Column(name = "certificate_name", nullable = false)
    private String certificateName;

    @NotBlank(message = "Issued by is required")
    @Column(name = "issued_by", nullable = false)
    private String issuedBy;

    @PastOrPresent(message = "Issue date cannot be in the future")
    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Future(message = "Expiry date must be in the future")
    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;

    @NotBlank(message = "Document URL is required")
    @Column(name = "document_url", length = 500)
    private String documentUrl;

    @OneToMany(mappedBy = "qualityCertificate", fetch = FetchType.LAZY)
    private List<Product> products;

}

