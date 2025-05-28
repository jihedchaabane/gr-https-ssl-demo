package com.chj.gr.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.chj.gr.config.properties.CallerDestinationProperties;
import com.chj.gr.config.properties.CallerDestinationProperties.DestinationClient;
import com.chj.gr.enums.EnumResourceServer;

@Component
public class Ms1ClientService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("restTemplateSsl")
    private RestTemplate restTemplateSsl;
	
	@Autowired
    private CallerDestinationProperties callerDestinationProperties; 


    public String get() {
    	DestinationClient destinationClient = callerDestinationProperties.getDestinationClient(
    			EnumResourceServer.STS_MS1_SERVICE_REGISTRATION.getKey());
    	
    	String url = destinationClient.getResourceUri().concat("/get");
    	logger.info("Calling {}", url);
        return restTemplateSsl.getForObject(url, String.class);
    }
}