package com.martinnnachi.aopdemo;

import com.martinnnachi.aopdemo.config.DemoConfig;
import com.martinnnachi.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {

    public static void main(String[] args) {

        // read the config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( DemoConfig.class );

        // get the bean from the spring container
        AccountDAO theAccountDAO = context.getBean( "accountDAO", AccountDAO.class );

        // call method to find the accounts
        List<Account> theAccounts = theAccountDAO.findAccounts( false );

        System.out.println( "\n\nMain Program: AfterReturningDemoApp" );
        System.out.println( "-------------" );
        System.out.println(theAccounts );
        System.out.println( "\n" );

        // close the context
        context.close();

    }
}
