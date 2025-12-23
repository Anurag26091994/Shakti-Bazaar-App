package com.ecom.Shakti.Bazaar.serviceimpl.User_Access_Management;

import com.ecom.Shakti.Bazaar.Enum.User_Access_Management.EventType;
import com.ecom.Shakti.Bazaar.service.User_Access_Management.UserService;
import com.ecom.Shakti.Bazaar.util.FormLogger;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

@Service
public class EventService {

    private final UserService userService;

    public EventService(UserService userService) {
        this.userService = userService;
    }

    public String processEvent(String eventName, EventType eventType,
                               JsonNode data, Boolean flag) {
        String response = "";
        FormLogger.info("EventService: processEvent called with eventName: " + eventName +
                ", eventType: " + eventType + ", flag: " + flag);
        try {
            if (flag) {
                FormLogger.info("EventService: Processing event as flag is true.");
                if (eventType.equals(EventType.USER)) {
                    FormLogger.info("EventService: Handling USER event: " + eventName);
                    switch (eventName.toUpperCase()) {
                        case "CREATEUSER":
                            FormLogger.info("EventService: Creating user with event name: " + eventName +
                                    " and data: " + data.toString());
                            response = userService.createUser(data);
                            FormLogger.info("EventService: User created with response: " + response);
                            break;
                        case "GETUSERINFO":
                            FormLogger.info("EventService: Getting user info with event name: " + eventName +
                                    " and data: " + data.toString());
                            response = userService.getUserInfo(data);
                            FormLogger.info("EventService: Retrieved user info with response: " + response);
                            break;
                        case "GETUSERDETAILSBYEMAIL":
                            FormLogger.info("EventService: Getting user details by email with event name: " + eventName +
                                    " and data: " + data.toString());
                            response = userService.getUserDetailsByEmail(data);
                            FormLogger.info("EventService: Retrieved user details by email with response: " + response);
                            break;
                        case "DELETEUSER":
                            FormLogger.info("EventService: Deleting user with event name: " + eventName +
                                    " and data: " + data.toString());
                            response = userService.deleteUser(data);
                            FormLogger.info("EventService: User deleted with response: " + response);
                            break;
                        default:
                            FormLogger.warn("EventService: Unsupported USER event name: " + eventName);
                            return "Unsupported USER event name: " + eventName;
                    }
                    FormLogger.info("EventService: Response from process event case: " + eventName);
                    return response;
                }

                if (eventType.toString().isEmpty()) {
                    response = "Event type is empty, cannot process event.";
                    return response;
                }
            } else {
                response = "Flag is false, event not processed.";
                FormLogger.info("EventService: " + response);
                return response;
            }
            FormLogger.info("EventService: Final response from processEvent: " + response);
            return response;
        } catch (Exception e) {
            FormLogger.error("EventService: Error in processEvent - " + e.getMessage());
            return "Error processing event: " + e.getMessage();
        }
    }
}
