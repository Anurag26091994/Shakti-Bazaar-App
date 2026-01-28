package com.ecom.Shakti.Bazaar.repository.SHG_Management;

import com.ecom.Shakti.Bazaar.entity.SHG_Management.SHG;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShgRepository extends JpaRepository<SHG, Long> {
    boolean existsByRegistrationNo(String registrationNo);
}
