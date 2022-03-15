package com.martinnnachi.aopdemo;

import com.martinnnachi.aopdemo.config.DemoConfig;
import com.martinnnachi.aopdemo.service.TrafficFortuneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger( AroundDemoApp.class.getName() );


        // read the config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( DemoConfig.class );

        // get bean from spring container
        TrafficFortuneService fortuneService = context.getBean( "trafficFortuneService", TrafficFortuneService.class );


        logger.info( "\nMain Program: AroundDemoApp" );
        logger.info( "Calling getFortune" );

        String data = fortuneService.getFortune();
        logger.info( "\nMy fortune is: " + data );

        logger.info( "Finished" );


        // close the context
        context.close();

    }
}
