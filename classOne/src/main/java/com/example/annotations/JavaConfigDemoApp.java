package com.example.annotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {


    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext( SportConfig.class );

        // get bean from spring container
        Coach theCoach = context.getBean( "tennisCoach", Coach.class );

        // call methods on the bean
        System.out.println( theCoach.getDailyWorkout() );

        // call method to get daily fortune
        System.out.println( theCoach.getDailyFortune() );
        // close container
        context.close();

    }
}
