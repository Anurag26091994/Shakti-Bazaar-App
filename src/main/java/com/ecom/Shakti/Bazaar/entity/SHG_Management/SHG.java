package com.ecom.Shakti.Bazaar.entity.SHG_Management;

import com.ecom.Shakti.Bazaar.Enum.SHG_Management.SHGStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "shg")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SHG {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shg_id")
    private Long shgId;

    @NotBlank(message = "SHG name is required")
    @Column(name = "shg_name", nullable = false)
    private String shgName;

    @NotBlank(message = "Registration number is required")
    @Column(name = "registration_no", unique = true, nullable = false)
    private String registrationNo;

    @PastOrPresent(message = "Date of registration cannot be in future")
    @Column(name = "date_of_registration")
    private LocalDate dateOfRegistration;

    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Invalid contact number")
    @Column(name = "contact_number")
    private String contactNumber;

    @NotBlank(message = "Address is required")
    @Column(name = "address", length = 500)
    private String address;

    @NotBlank(message = "Bank account number is required")
    @Column(name = "bank_account_no")
    private String bankAccountNo;

    @Pattern(
            regexp = "^[A-Z]{4}0[A-Z0-9]{6}$",
            message = "Invalid IFSC code"
    )
    @Column(name = "ifsc_code")
    private String ifscCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "federation_id", nullable = false)
    private Federation federation;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SHGStatus status;
}

