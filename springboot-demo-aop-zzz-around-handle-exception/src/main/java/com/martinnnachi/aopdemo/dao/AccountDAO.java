package com.martinnnachi.aopdemo.dao;

import com.martinnnachi.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {


    private String name;
    private String serviceCode;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    // add a new method: findAccounts()
    public List<Account> findAccounts(boolean tripWire) {

        // simulate exception
        if (tripWire) {
            throw new RuntimeException("Aha! You tripped!!");
        }

        List<Account> myAccounts = new ArrayList<>();

        // create sample accounts
        Account temp1 = new Account( "Gloria", "Silver" );
        Account temp2 = new Account( "Martin", "Platinum" );
        Account temp3 = new Account( "Cordelia", "Gold" );

        //add them to the list
        myAccounts.add( temp1 );
        myAccounts.add( temp2 );
        myAccounts.add( temp3 );

        return myAccounts;
    }

    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println( getClass() + ANSI_GREEN + " : DOING MY DB WORK: ADDING ACCOUNT" + ANSI_RESET );
    }

    public void doWork() {
        System.out.println( getClass() + ANSI_GREEN + ": doWork()" + ANSI_RESET );
    }

    public String getName() {
        System.out.println( getClass() + ANSI_GREEN + ": getName()" + ANSI_RESET );
        return name;
    }

    public void setName(String name) {
        System.out.println( getClass() + ANSI_GREEN + ": setName()" + ANSI_RESET );
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println( getClass() + ANSI_GREEN + ": getServiceCode()" + ANSI_RESET );
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println( getClass() + ANSI_GREEN + ": setServiceCode()" + ANSI_RESET );
        this.serviceCode = serviceCode;
    }
}
