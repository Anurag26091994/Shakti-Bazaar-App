package com.ecom.Shakti.Bazaar.entity.MIS_And_ReportingModule;

import com.ecom.Shakti.Bazaar.Enum.MIS_And_ReportingModule.ReportType;
import com.ecom.Shakti.Bazaar.entity.SHG_Management.Federation;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "mis_reports")
public class MISReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mis_id")
    private Long misId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "federation_id", nullable = false)
    private Federation federationId; // FK reference to shg_management

    @Enumerated(EnumType.STRING)
    @Column(name = "report_type", nullable = false)
    private ReportType reportType;

    @Column(name = "generated_date", nullable = false)
    private LocalDate generatedDate;

    @Column(name = "summary")
    private String summary;

    @Column(name = "file_url")
    private String fileUrl;
}
