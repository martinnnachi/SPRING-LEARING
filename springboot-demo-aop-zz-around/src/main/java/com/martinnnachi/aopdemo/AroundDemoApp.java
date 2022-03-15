package com.martinnnachi.aopdemo;

import com.martinnnachi.aopdemo.config.DemoConfig;
import com.martinnnachi.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {

    public static void main(String[] args) {

        // read the config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( DemoConfig.class );

        // get bean from spring container
        TrafficFortuneService fortuneService = context.getBean( "trafficFortuneService", TrafficFortuneService.class );


        System.out.println("\nMain Program: AroundDemoApp");
        System.out.println("Calling getFortune");

        String data = fortuneService.getFortune();
        System.out.println("\nMy fortune is: " + data);

        System.out.println("Finished");


        // close the context
        context.close();

    }
}
