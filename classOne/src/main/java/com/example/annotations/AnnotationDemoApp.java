package com.example.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {


    public static void main(String[] args) {

        // read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext( "annotationsApplicationContext.xml" );

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
