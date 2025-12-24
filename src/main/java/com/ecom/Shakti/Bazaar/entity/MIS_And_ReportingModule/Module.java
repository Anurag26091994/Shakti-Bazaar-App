package com.ecom.Shakti.Bazaar.entity.MIS_And_ReportingModule;

import com.ecom.Shakti.Bazaar.Enum.MIS_And_ReportingModule.ModuleName;
import jakarta.persistence.*;

@Entity
@Table(name="modules")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moduleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "module_name", nullable = false, unique = true)
    private ModuleName moduleName;
}
