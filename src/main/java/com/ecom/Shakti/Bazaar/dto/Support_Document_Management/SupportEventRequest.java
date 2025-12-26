package com.ecom.Shakti.Bazaar.dto.Support_Document_Management;

import com.ecom.Shakti.Bazaar.Enum.Support_Document_Management.SupportEventType;
import tools.jackson.databind.JsonNode;

public class SupportEventRequest {

    private SupportEventType eventType;
    private String eventName;
    private JsonNode data;
    private Boolean flag;

    public SupportEventRequest(String eventName,
                               SupportEventType eventType,
                               JsonNode data,
                               Boolean flag) {
        this.eventType = eventType;
        this.eventName = eventName;
        this.data = data;
        this.flag = flag;
    }

    public SupportEventType getEventType() {
        return eventType;
    }

    public void setEventType(SupportEventType eventType) {
        this.eventType = eventType;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public JsonNode getData() {
        return data;
    }

    public void setData(JsonNode data) {
        this.data = data;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "SupportEventRequest{" +
                "eventType=" + eventType +
                ", eventName='" + eventName + '\'' +
                ", jsonNode data=" + data +
                ", flag=" + flag +
                '}';
    }
}
