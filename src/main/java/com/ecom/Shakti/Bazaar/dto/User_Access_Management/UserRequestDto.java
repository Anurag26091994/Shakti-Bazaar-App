package com.ecom.Shakti.Bazaar.dto.User_Access_Management;

import com.ecom.Shakti.Bazaar.entity.Order_Payment_And_DeliveryModule.Order;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserRequestDto {

    private Long userId;

    private String firstName;

    private String lastName;

    private String userName;

    private String password;

    private String mobileNumber;

    private String address;

    private String emailId;

    private String role;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
