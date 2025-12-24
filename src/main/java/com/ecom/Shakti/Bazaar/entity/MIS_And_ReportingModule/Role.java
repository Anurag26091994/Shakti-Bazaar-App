package com.ecom.Shakti.Bazaar.entity.MIS_And_ReportingModule;

import com.ecom.Shakti.Bazaar.Enum.MIS_And_ReportingModule.RoleName;
import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name", nullable = false)
    private RoleName roleName;

    @Column(name = "role_variant")
    private String roleVariant; // Super Admin, State Admin, MIS Officer, Auditor, etc.

    @Column(name = "purpose")
    private String purpose;

}
