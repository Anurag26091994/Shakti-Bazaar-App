package com.ecom.Shakti.Bazaar.entity.SHG_Management;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(
        name = "district",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "region_code")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_id")
    private Long districtId;

    @NotBlank(message = "District name is required")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "State name is required")
    @Column(name = "state", nullable = false)
    private String state;

    @NotBlank(message = "Region code is required")
    @Column(name = "region_code", nullable = false, unique = true)
    private String regionCode;

   /* @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "federation_id",
            nullable = false
    )
    private Federation federation;*/
}
