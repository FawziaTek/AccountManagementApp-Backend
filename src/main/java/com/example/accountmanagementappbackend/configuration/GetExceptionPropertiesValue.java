package com.example.accountmanagementappbackend.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
/**
 * @author Fawzia Tekaya in 24/01/2023
 * <p>
 * GetExceptionPropertiesValue class : in this class we will read exception values from  exception.properties file
 */
@PropertySource("classpath:exception.properties")
@Configuration
public class GetExceptionPropertiesValue {
    @Autowired
    private Environment env;

    public String getE03() {
        return env.getProperty("E03");
    }

    public String getE02() {
        return env.getProperty("E02");
    }
    public String getE01() {
        return env.getProperty("E01");
    }


}
