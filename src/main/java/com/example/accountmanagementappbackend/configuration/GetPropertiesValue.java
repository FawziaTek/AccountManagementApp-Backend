package com.example.accountmanagementappbackend.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class GetPropertiesValue {


    @Autowired
    private Environment env;

    //security

    public String getSecurityUsernameFromProp(){
        return env.getProperty("spring.security.username");
    }
    public String getSecurityPasswordFromProp() {
        return env.getProperty("spring.security.password");
    }


    // swagger
    public String getSwaggerVersionFromProp() {
        return env.getProperty("swaggerVersion");
    }

    public String getSwaggerBasePackage() {
        return env.getProperty("swaggerBasePackage");
    }

    public String getSwaggerTitle() {
        return env.getProperty("swaggerTitle");
    }

    public String getSwaggerDescription() {
        return env.getProperty("swaggerDescription");
    }

    public String getSwaggerLicense() {
        return env.getProperty("swaggerLicense");
    }
}
