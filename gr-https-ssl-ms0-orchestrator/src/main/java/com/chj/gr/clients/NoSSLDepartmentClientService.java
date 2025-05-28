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
public class NoSSLDepartmentClientService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	@Qualifier("restTemplate")
	private RestTemplate restTemplate;
	
	@Autowired
	private CallerDestinationProperties callerDestinationProperties;

	public String getDepartments() {
		DestinationClient destinationClient = callerDestinationProperties
				.getDestinationClient(EnumResourceServer.STS_DEPARTMENT_SERVICE_REGISTRATION.getKey());

		String url = destinationClient.getResourceUri().concat("/department/all");
		logger.info("Calling {}", url);
		return restTemplate.getForObject(url, String.class);
	}
}