package com.example.accountmanagementappbackend.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

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
