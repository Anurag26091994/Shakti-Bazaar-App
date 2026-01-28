package com.ecom.Shakti.Bazaar.dto.SHG_Management;

import com.ecom.Shakti.Bazaar.Enum.SHG_Management.ShgEventType;
import lombok.Getter;
import lombok.Setter;
import tools.jackson.databind.JsonNode;

@Getter
@Setter
public class ShgEventRequest {

    private String eventName;       // CREATEDISTRICT, CREATEFEDERATION, CREATESHG
    private ShgEventType eventType; // DISTRICT / FEDERATION / SHG
    private JsonNode data;          // actual payload
    private Boolean flag;


}
