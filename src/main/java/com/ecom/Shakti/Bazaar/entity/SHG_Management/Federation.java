package com.ecom.Shakti.Bazaar.entity.SHG_Management;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
        name = "federation",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "phone")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Federation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "federation_id")
    private Long federationId;

    @NotBlank(message = "Federation name is required")
    @Column(name = "name", nullable = false)
    private String name;

    // FK reference (simple approach)
    @NotNull(message = "District ID is required")
    @Column(name = "district_id", nullable = false)
    private Long districtId;

    @NotBlank(message = "Contact person is required")
    @Column(name = "contact_person")
    private String contactPerson;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    @Column(name = "email", nullable = false)
    private String email;

    @Pattern(
            regexp = "^[6-9][0-9]{9}$",
            message = "Invalid phone number"
    )
    @Column(name = "phone", nullable = false)
    private String phone;

    @Min(value = 0, message = "Total SHGs cannot be negative")
    @Column(name = "total_shgs")
    private Integer totalShgs;

    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "federation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SHG> shgs;

    @OneToMany(
            mappedBy = "federation",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<District> districts;



    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDateTime.now();
        if (this.totalShgs == null) {
            this.totalShgs = 0;
        }
    }
}
