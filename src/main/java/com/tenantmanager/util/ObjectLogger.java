package com.tenantmanager.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ObjectLogger {

    private static final Logger logger = LoggerFactory.getLogger(ObjectLogger.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void objectLogAsJSON(Object object) throws JsonProcessingException {
        logger.info("Object as JSON: " + objectMapper.writeValueAsString(object));
    }
}
