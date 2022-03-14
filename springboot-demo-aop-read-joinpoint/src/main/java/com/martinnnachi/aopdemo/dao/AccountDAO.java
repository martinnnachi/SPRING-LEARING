package com.martinnnachi.aopdemo.dao;

import com.martinnnachi.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {


    private String name;
    private String serviceCode;
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

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
