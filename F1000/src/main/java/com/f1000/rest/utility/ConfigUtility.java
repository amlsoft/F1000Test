package com.f1000.rest.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ConfigUtility {

	@Autowired
    private Environment environment;

    public String getProperty(String pPropertyKey) {
        return environment.getProperty(pPropertyKey);
    }
}
