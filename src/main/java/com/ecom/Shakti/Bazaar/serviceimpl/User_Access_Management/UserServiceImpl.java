package com.ecom.Shakti.Bazaar.serviceimpl.User_Access_Management;

import com.ecom.Shakti.Bazaar.dto.User_Access_Management.UserRequestDto;
import com.ecom.Shakti.Bazaar.entity.User_Access_Management.User;
import com.ecom.Shakti.Bazaar.exception.BusinessException;
import com.ecom.Shakti.Bazaar.repository.User_Access_Management.UserRepository;
import com.ecom.Shakti.Bazaar.service.User_Access_Management.UserService;
import com.ecom.Shakti.Bazaar.util.CommonValidations;
import com.ecom.Shakti.Bazaar.util.EventHandler;
import com.ecom.Shakti.Bazaar.util.FormLogger;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Service
public  class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

//    private final EventHandler eventHandler;

    private final ObjectMapper objectMapper;

    public UserServiceImpl(UserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }


    @Transactional
    @Override
    public String createUser(JsonNode data) {
        FormLogger.info("get user data: "+data);
        try{
//            data.get("firstName").asString();
            UserRequestDto userRequestDto= objectMapper.treeToValue(data, UserRequestDto.class);

            //validate dto
            validateCreateUser(userRequestDto);

            if (userRepository.findByEmailId(userRequestDto.getEmailId()).isPresent()) {
                throw new BusinessException(
                        "User already exists with emailId: " + userRequestDto.getEmailId()
                );
            }
            if (userRepository.findByUserName(userRequestDto.getUserName()).isPresent()) {
                throw new BusinessException(
                        "User already exists with userName: " + userRequestDto.getUserName()
                );
            }

            User user= User.builder()
                    .firstName(userRequestDto.getFirstName())
                    .lastName(userRequestDto.getLastName())
                    .userName(userRequestDto.getUserName())
                    .password(userRequestDto.getPassword())
                    .emailId(userRequestDto.getEmailId())
                    .mobileNumber(userRequestDto.getMobileNumber())
                    .address(userRequestDto.getAddress())
                    .role(userRequestDto.getRole())
                    .build();

            userRepository.save(user);

            FormLogger.info("UserService: User created successfully");
            return "User created successfully";

        }
        catch (IllegalArgumentException e) {
            FormLogger.warn("UserService: Validation failed - " , e);
            return  e.getMessage();

        }
        catch (Exception e) {
            FormLogger.error("UserService: Error creating user", e);
//            throw new RuntimeException("Failed to create user"+e.getMessage());
            return "Error: "+e.getMessage();
        }
    }

    @Override
    public String getUserInfo(JsonNode data) {
        return "";
    }

    @Override
    public String getUserDetailsByEmail(JsonNode data) {
        return "";
    }

    @Override
    public String deleteUser(JsonNode data) {
        return "";
    }

    @Override
    public String updateUser(JsonNode payload) {
        return "";
    }

    private void validateCreateUser(UserRequestDto dto) {

        if (CommonValidations.isNullOrEmpty(dto.getFirstName())
                || !CommonValidations.isValidName(dto.getFirstName())) {
            throw new IllegalArgumentException("Invalid first name");
        }

        if (CommonValidations.isNullOrEmpty(dto.getLastName())
                || !CommonValidations.isValidName(dto.getLastName())) {
            throw new IllegalArgumentException("Invalid last name");
        }

        if (CommonValidations.isNullOrEmpty(dto.getEmailId())
                || !CommonValidations.isValidEmail(dto.getEmailId())) {
            throw new IllegalArgumentException("Invalid email address");
        }

        if (CommonValidations.isNullOrEmpty(dto.getMobileNumber())
                || !CommonValidations.isNumeric(dto.getMobileNumber())) {
            throw new IllegalArgumentException("Invalid mobile number");
        }
    }

}
