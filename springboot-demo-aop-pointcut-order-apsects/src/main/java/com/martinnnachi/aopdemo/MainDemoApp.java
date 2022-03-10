package com.martinnnachi.aopdemo;

import com.martinnnachi.aopdemo.config.DemoConfig;
import com.martinnnachi.aopdemo.dao.AccountDAO;
import com.martinnnachi.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        // read the config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( DemoConfig.class );

        // get the bean from the spring container
        AccountDAO theAccountDAO = context.getBean( "accountDAO", AccountDAO.class );

        // call the business method
        Account myAccount = new Account();
        theAccountDAO.addAccount( myAccount, true );
        theAccountDAO.doWork();

        // call the accountdao getter/setter methods
        theAccountDAO.setName( "foobar" );
        theAccountDAO.setServiceCode( "A022341" );

        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();

        System.out.println( name + ", " + code );

        // get the membership bean from the spring container
        MembershipDAO membershipDAO = context.getBean( "membershipDAO", MembershipDAO.class );

        // call membership business method
        membershipDAO.addMember();
        membershipDAO.goToSleep();

        // close the context
        context.close();

    }
}
