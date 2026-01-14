package com.ecom.Shakti.Bazaar.repository.User_Access_Management;

import com.ecom.Shakti.Bazaar.entity.User_Access_Management.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmailId(String emailId);

    void deleteByEmailId(String emailId);

    Optional<Object> findByUserName(String userName);
}
