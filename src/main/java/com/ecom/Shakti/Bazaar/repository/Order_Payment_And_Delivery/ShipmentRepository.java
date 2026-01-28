package com.ecom.Shakti.Bazaar.repository.Order_Payment_And_Delivery;

import com.ecom.Shakti.Bazaar.entity.Order_Payment_And_Delivery.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}


