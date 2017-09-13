package com.pei.billinginquiry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Main application.
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 7, 2017
 */
@SpringBootApplication 
public class Application extends SpringBootServletInitializer
{
    /**
     * Main initial point to run the application.
     * @param args 
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    /**
     * Integration to generate the "war" file.
     * @param application
     * @return 
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        System.setProperty("jasypt.encryptor.password", "H4rD-70-6u35S");
        return application.sources(Application.class);
    }
}
