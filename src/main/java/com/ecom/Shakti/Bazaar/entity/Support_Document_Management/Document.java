package com.ecom.Shakti.Bazaar.entity.Support_Document_Management;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "documents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;

    @Column(name = "uploaded_by", nullable = false)
    private Long uploadedBy;   // User ID or SHG ID

    @Column(name = "file_name", nullable = false)
    private String fileName;

    @Column(name = "file_url", nullable = false)
    private String fileUrl;

    @Column(name = "document_type", nullable = false)
    private String documentType;   // Invoice, Proof, Certificate

    @Column(name = "upload_date", nullable = false)
    private LocalDateTime uploadDate;
}
