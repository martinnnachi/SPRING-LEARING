package com.martinnnachi.springbootsecurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityApplication {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(SpringBootSecurityApplication.class);

        logger.info("Starting Spring Security");
        SpringApplication.run( SpringBootSecurityApplication.class, args );
    }

}
