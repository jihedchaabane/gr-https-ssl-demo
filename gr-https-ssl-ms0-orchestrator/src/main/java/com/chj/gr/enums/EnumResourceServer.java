package com.chj.gr.enums;

/**
 * ${spring.application.name}-***.yml
 */
public enum EnumResourceServer {
	STS_DEFAULT_REGISTRATION					("client0",  "sts-default-registration"),
	STS_MS1_SERVICE_REGISTRATION				("client1",  "sts-ms1-service-registration"),
	STS_MS2_SERVICE_REGISTRATION				("client2",  "sts-ms2-service-registration"),
	STS_MS3_SERVICE_REGISTRATION				("client3",  "sts-ms3-service-registration"),
	STS_MS4_SERVICE_REGISTRATION				("client4",  "sts-ms4-service-registration"),
	STS_MS5_SERVICE_REGISTRATION				("client5",  "sts-ms5-service-registration"),
	
	STS_DEPARTMENT_SERVICE_REGISTRATION			("client6",  "sts-gr-nohttps-ssl-department-registration"),
	STS_STUDENT_SERVICE_REGISTRATION			("client7",  "sts-gr-nohttps-ssl-student-registration");

    private final String key;
    private final String registrationId;

    EnumResourceServer(String key, String registrationId) {
        this.key = key;
        this.registrationId = registrationId;
    }

	public String getKey() {
		return key;
	}

	public String getRegistrationId() {
		return registrationId;
	}
}
