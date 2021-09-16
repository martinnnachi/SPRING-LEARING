package com.example.project;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Slf4j
@SpringBootApplication
public class ClassOneApplication {

    public static void main(String[] args) {
        SpringApplication.run( ClassOneApplication.class, args );
        Logger logger = LoggerFactory.getLogger( ClassOneApplication.class );
        logger.info( "INFO message" );
        logger.debug( "DEBUG message" );

        // Load the spring configuration file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext( "applicationContext.xml" );

        // Retrieve the bean from the container
        Coach theCoach = context.getBean( "myCoach", Coach.class );

        // Call methods on the bean
        System.out.println( theCoach.getDailyWorkout() );
        System.out.println( theCoach.getDailyFortune() );

        // Close the context
        context.close();

    }

}
