package com.ecom.Shakti.Bazaar.service.User_Access_Management;

import tools.jackson.databind.JsonNode;

public interface UserService {
    String createUser(JsonNode data);

    String getUserInfo(JsonNode data);

    String getUserDetailsByEmail(JsonNode data);

    String deleteUser(JsonNode data);

    String updateUser(JsonNode payload);
}
