package com.ecom.Shakti.Bazaar.repository.User_Access_Management;

import com.ecom.Shakti.Bazaar.entity.User_Access_Management.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
