package com.chj.gr.clients;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.chj.gr.entity.StudentEntity;
import com.chj.gr.enums.EnumResourceServer;
import com.chj.gr.properties.CallerDestinationProperties;
import com.chj.gr.properties.CallerDestinationProperties.DestinationClient;

@Component
public class StudentClient {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    private final RestTemplate restTemplate;

    private CallerDestinationProperties callerDestinationProperties; 

    public StudentClient(RestTemplate restTemplate, CallerDestinationProperties callerDestinationProperties) {
        this.restTemplate = restTemplate;
        this.callerDestinationProperties = callerDestinationProperties;
    }
    
    public List<StudentEntity> getBarEureka() {
    	
    	DestinationClient destinationClient = callerDestinationProperties.getDestinationClient(
    			EnumResourceServer.STS_MS2_STUDENT_SERVICE_REGISTRATION.getKey());
    	
    	String allStudents = destinationClient.getResourceUri().concat("/student/all");
    	logger.info("Calling {}", allStudents);
        return restTemplate.getForObject(allStudents, List.class);
    }

}
