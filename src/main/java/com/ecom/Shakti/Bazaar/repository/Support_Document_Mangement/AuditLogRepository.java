package com.ecom.Shakti.Bazaar.repository.Support_Document_Mangement;

import com.ecom.Shakti.Bazaar.entity.Support_Document_Management.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {}
