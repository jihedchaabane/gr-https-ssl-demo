package com.chj.gr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chj.gr.clients.Ms1ClientService;
import com.chj.gr.clients.Ms2ClientService;
import com.chj.gr.clients.Ms3ClientService;
import com.chj.gr.clients.Ms4ClientService;
import com.chj.gr.clients.Ms5ClientService;
import com.chj.gr.clients.NoSSLDepartmentClientService;
import com.chj.gr.clients.NoSSLStudentClientService;

@RestController
@RequestMapping("/get")
public class Ms0OrchestratorController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
    private final Ms1ClientService ms1ClientService;
    private final Ms2ClientService ms2ClientService;
    private final Ms3ClientService ms3ClientService;
    private final Ms4ClientService ms4ClientService;
    private final Ms5ClientService ms5ClientService;
    private final NoSSLDepartmentClientService noSSLDepartmentClientService;
    private final NoSSLStudentClientService noSSLStudentClientService;

    public Ms0OrchestratorController(
    		Ms1ClientService ms1ClientService,
    		Ms2ClientService ms2ClientService,
			Ms3ClientService ms3ClientService, 
			Ms4ClientService ms4ClientService,
			Ms5ClientService ms5ClientService,
			NoSSLDepartmentClientService noSSLDepartmentClientService,
			NoSSLStudentClientService noSSLStudentClientService
	) {
		super();
		this.ms1ClientService = ms1ClientService;
		this.ms2ClientService = ms2ClientService;
		this.ms3ClientService = ms3ClientService;
		this.ms4ClientService = ms4ClientService;
		this.ms5ClientService = ms5ClientService;
		this.noSSLDepartmentClientService = noSSLDepartmentClientService;
		this.noSSLStudentClientService = noSSLStudentClientService;
	}

    @GetMapping("/ms1")
    public String ms1() {
    	
    	logger.info("Calling GR-HTTPS-SSL-MS1");
    	
        return this.ms1ClientService.get();
    }

    @GetMapping("/ms2")
    public String ms2() {
    	
    	logger.info("Calling GR-HTTPS-SSL-MS2");
    	
        return this.ms2ClientService.get();
    }

    @GetMapping("/ms3")
    public String ms3() {
    	
    	logger.info("Calling GR-HTTPS-SSL-MS3");
    	
        return this.ms3ClientService.get();
    }

    @GetMapping("/ms4")
    public String ms4() {
    	
    	logger.info("Calling GR-HTTPS-SSL-MS4");
    	
        return this.ms4ClientService.get();
    }
    
    @GetMapping("/ms5")
    public String ms5() {
    	
    	logger.info("Calling GR-HTTPS-SSL-MS5");
    	
        return this.ms5ClientService.get();
    }
    
    @GetMapping("/nossl/departments")
    public String departments() {
    	
    	logger.info("Calling GR-NOHTTPS-SSL-DEPARTMENT");
    	
        return this.noSSLDepartmentClientService.getDepartments();
    }
    
    @GetMapping("/nossl/students")
    public String students() {
    	
    	logger.info("Calling GR-NOHTTPS-SSL-STUDENT");
    	
        return this.noSSLStudentClientService.getStudents();
    }
    
}
