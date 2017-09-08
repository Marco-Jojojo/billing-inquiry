package com.pei.billinginquiry;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Marco Alvarado <marco.alvarado@softtek.com>
 * @date Sep 7, 2017
 */
@SpringBootApplication 
public class Application
{
    public static void main(String[] args) {
        System.setProperty("jasypt.encryptor.password", "H4rD-70-6u35S");
        SpringApplication.run(Application.class, args);
    }
}
