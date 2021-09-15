package com.example.classone;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

    public static void main(String[] args) {

        // Load the spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "applicationContext.xml" );

        // retrieve the bean from the container
        CricketCoach theCoach = context.getBean( "myCricketCoach", CricketCoach.class );

        // call the methods on the bean
        System.out.println( theCoach.getDailyWorkout() );
        System.out.println( theCoach.getDailyFortune() );

        System.out.println( theCoach.getEmailAddress() );
        System.out.println( theCoach.getTeam() );
        // close the context
        context.close();
    }
}
