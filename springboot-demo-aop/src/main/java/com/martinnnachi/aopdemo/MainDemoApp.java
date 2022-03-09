package com.martinnnachi.aopdemo;

import com.martinnnachi.aopdemo.config.DemoConfig;
import com.martinnnachi.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        // read the soring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( DemoConfig.class );

        // get the bean from the spring container
        AccountDAO theAccountDAO = context.getBean( "accountDAO", AccountDAO.class );

        // call the business method
        theAccountDAO.addAccount();

        //  do it again!
        System.out.println("\n let's call it again\n");

        // call the business method again
        theAccountDAO.addAccount();

        // close the context
        context.close();

    }
}
