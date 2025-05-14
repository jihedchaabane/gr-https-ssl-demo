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
	      
	# Ou configurez programmatiquement RestTemplate pour utiliser le truststore:
	   WORKS FINE.
	*/
    @Bean("restTemplateSsl")
    @LoadBalanced
    public RestTemplate restTemplate() throws Exception {
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
    
    @Bean("restTemplate")
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }
    /**
     @TODO
     @LoadBalanced
    java.lang.IllegalStateException: No instances available for localhost
	at org.springframework.cloud.loadbalancer.blocking.client.BlockingLoadBalancerClient.execute(BlockingLoadBalancerClient.java:89) ~[spring-cloud-loadbalancer-3.1.8.jar:3.1.8]
	at org.springframework.cloud.client.loadbalancer.LoadBalancerInterceptor.intercept(LoadBalancerInterceptor.java:56) ~[spring-cloud-commons-3.1.8.jar:3.1.8]
	at org.springframework.http.client.InterceptingClientHttpRequest$InterceptingRequestExecution.execute(InterceptingClientHttpRequest.java:93) ~[spring-web-5.3.31.jar:5.3.31]
	at org.springframework.boot.actuate.metrics.web.client.MetricsClientHttpRequestInterceptor.intercept(MetricsClientHttpRequestInterceptor.java:86) ~[spring-boot-actuator-2.7.18.jar:2.7.18]
	*/
}