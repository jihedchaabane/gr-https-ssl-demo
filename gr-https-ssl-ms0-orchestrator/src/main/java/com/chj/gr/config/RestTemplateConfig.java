package com.chj.gr.config;

import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	/**
		@TODO din't work!
		javax:
		  net:
		    ssl:
		      trustStore: classpath:ms1-truststore.jks
		      trustStorePassword: jihed1234
	      
	   Ou configurez programmatiquement RestTemplate pour utiliser le truststore: (
	   			FONCTIONNE bien SANS eureka.instance.preferIpAddress: true
	   			https://localhost:8443/..
	   )
	*/
	
	/**
    @LoadBalanced
    ==> l'appel avec https://MON_SERVICE_APP_NAME
    Il faut que : eureka.instance.preferIpAddress: true
    
    @TODO NE FONCTIONNE PAS ENCORE pour les appels SSL.
    */
    @Bean("restTemplateSsl")
    @LoadBalanced
    public RestTemplate restTemplateSsl() throws Exception {
        KeyStore trustStore = KeyStore.getInstance("JKS");
        trustStore.load(getClass().getResourceAsStream("/ms1-truststore.jks"), "jihed1234".toCharArray());

        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(trustStore, null)
                .build();

        SSLConnectionSocketFactory socketFactory = new SSLConnectionSocketFactory(sslContext);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(socketFactory)
                .build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
        factory.setHttpClient(httpClient);

        return new RestTemplate(factory);
    }
    
    /**
     @LoadBalanced
     ==> l'appel avec http://MON_SERVICE_APP_NAME
     Il faut que : eureka.instance.preferIpAddress: true
     
     FONCTIONNE CORRECTEMENT pour les appels non SSL.
     */
    @Bean("restTemplate")
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }
}