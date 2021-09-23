package com.example.annotations;

import com.example.project.ClassOneApplication;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@Slf4j
public class SwimJavaConfigDemoApp {


    public static void main(String[] args) {
        SpringApplication.run( SwimJavaConfigDemoApp.class, args );
        Logger logger = LoggerFactory.getLogger( ClassOneApplication.class );
        logger.info( "INFO message" );
        logger.debug( "DEBUG message" );

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext( SportConfig.class );

        // get bean from spring container
        SwimCoach theCoach = context.getBean( "swimCoach", SwimCoach.class );

        // call methods on the bean
        System.out.println( theCoach.getDailyWorkout() );

        // call method to get daily fortune
        System.out.println( theCoach.getDailyFortune() );

        // call swim coach methods...has the property values injected
        System.out.println( "email: " + theCoach.getEmail() );
        System.out.println( "team: " + theCoach.getTeam() );

        // close container
        context.close();

    }
}
