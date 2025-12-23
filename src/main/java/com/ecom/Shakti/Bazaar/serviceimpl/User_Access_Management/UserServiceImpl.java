package com.ecom.Shakti.Bazaar.serviceimpl.User_Access_Management;

import com.ecom.Shakti.Bazaar.service.User_Access_Management.UserService;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

@Service
public  class UserServiceImpl implements UserService {
    @Override
    public String createUser(JsonNode data) {
        return "";
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
}
