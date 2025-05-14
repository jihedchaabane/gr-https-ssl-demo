package com.chj.gr.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.chj.gr.enums.EnumResourceServer;
import com.chj.gr.properties.CallerDestinationProperties;
import com.chj.gr.properties.CallerDestinationProperties.DestinationClient;

@Component
public class Ms1ClientService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    private final RestTemplate restTemplate;
    
    private CallerDestinationProperties callerDestinationProperties; 

    public Ms1ClientService(@Qualifier("restTemplateSsl") RestTemplate restTemplate, CallerDestinationProperties callerDestinationProperties) {
        this.restTemplate = restTemplate;
        this.callerDestinationProperties = callerDestinationProperties;
    }

    public String get() {
    	DestinationClient destinationClient = callerDestinationProperties.getDestinationClient(
    			EnumResourceServer.STS_MS1_SERVICE_REGISTRATION.getKey());
    	
    	String url = destinationClient.getResourceUri().concat("/get");
    	logger.info("Calling {}", url);
        return restTemplate.getForObject(url, String.class);
    }
}