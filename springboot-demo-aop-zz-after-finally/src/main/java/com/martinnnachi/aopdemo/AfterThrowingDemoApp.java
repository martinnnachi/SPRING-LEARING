package com.martinnnachi.aopdemo;

import com.martinnnachi.aopdemo.config.DemoConfig;
import com.martinnnachi.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

    public static void main(String[] args) {

        // read the config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( DemoConfig.class );

        // get the bean from the spring container
        AccountDAO theAccountDAO = context.getBean( "accountDAO", AccountDAO.class );

        // call method to find the accounts
        List<Account> theAccounts = null;

        try {
            // add a boolean to simulate exceptions
            boolean tripWire = true;
            theAccounts = theAccountDAO.findAccounts( tripWire );
        } catch (Exception e) {
            System.out.println( "\n\nMain program caught exception: " + e );
        }

        System.out.println( "\n\nMain Program: AfterThrowingDemoApp" );
        System.out.println( "-------------" );
        System.out.println( theAccounts );
        System.out.println( "\n" );

        // close the context
        context.close();

    }
}
