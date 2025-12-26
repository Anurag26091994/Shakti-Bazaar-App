package com.ecom.Shakti.Bazaar.repository.Support_Document_Mangement;

import com.ecom.Shakti.Bazaar.entity.Support_Document_Management.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {}
