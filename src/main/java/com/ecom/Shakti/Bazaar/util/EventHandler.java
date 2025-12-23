package com.ecom.Shakti.Bazaar.util;


import com.ecom.Shakti.Bazaar.Enum.User_Access_Management.EventType;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

public interface EventHandler<T> {

    String handle(T form);
    EventType getEventType();
    String getEventName();
    Class<T> getFormClass();

    default String handleJson(JsonNode jsonNode, ObjectMapper mapper) {
        try {
            T form = mapper.treeToValue(jsonNode, getFormClass());
            return handle(form);
        } catch (Exception e) {
            throw new RuntimeException("Failed to handle JSON event or Parse data: ", e);
        }
    }
}
