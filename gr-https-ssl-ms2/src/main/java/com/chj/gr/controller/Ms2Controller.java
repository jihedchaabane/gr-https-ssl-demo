package com.chj.gr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class Ms2Controller {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    @GetMapping("/get")
    public String ms2() {
    	
    	logger.info("Hello from GR-HTTPS-SSL-MS2");
    	
        return "Hello from GR-HTTPS-SSL-MS2";
    }
    
}
