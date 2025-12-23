package com.ecom.Shakti.Bazaar.entity.User_Access_Management;

import com.ecom.Shakti.Bazaar.entity.Order_Payment_And_DeliveryModule.Order;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class User {

    @Id
    private Long userId;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
