package com.martinnnachi.aopdemo.dao;


import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";


    public void addMember() {
        System.out.println( getClass() + ANSI_GREEN + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT" + ANSI_RESET );

    }

    public void goToSleep() {
        System.out.println( getClass() + ANSI_GREEN + ": I'm going to sleep now" + ANSI_RESET );

    }

}
