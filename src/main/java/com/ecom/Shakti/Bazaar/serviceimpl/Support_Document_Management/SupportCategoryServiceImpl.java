package com.ecom.Shakti.Bazaar.serviceimpl.Support_Document_Management;

import com.ecom.Shakti.Bazaar.service.Support_Document_Management.SupportCategoryService;
import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;

@Service
public class SupportCategoryServiceImpl implements SupportCategoryService {

    @Override
    public String handleEvent(String eventName, JsonNode data) {
        switch (eventName.toUpperCase()) {
            case "CREATECATEGORY":
                return "Support Category Created";
            case "GETCATEGORIES":
                return "Support Categories Retrieved";
            default:
                return "Unsupported Category Event";
        }
    }
}
