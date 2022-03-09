package com.martinnnachi.aopdemo;

import com.martinnnachi.aopdemo.config.DemoConfig;
import com.martinnnachi.aopdemo.dao.AccountDAO;
import com.martinnnachi.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        // read the soring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( DemoConfig.class );

        // get the bean from the spring container
        AccountDAO theAccountDAO = context.getBean( "accountDAO", AccountDAO.class );

        // call the business method
        theAccountDAO.addAccount();

        // get the membership bean from the spring container
        MembershipDAO membershipDAO = context.getBean( "membershipDAO", MembershipDAO.class );

        // call membership business method
        membershipDAO.addMember();

        // close the context
        context.close();

    }
}
