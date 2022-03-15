package com.martinnnachi.springdemo.testdb;

import java.sql.DriverManager;

public class TestJdbc {

    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String username = "springstudent";
        String password = "springstudent";
        try{
            System.out.println("Connecting to database: " + jdbcUrl);
            DriverManager.getConnection( jdbcUrl, username, password );

            System.out.println("connection Successful!");
        }catch(Exception exc){
            exc.printStackTrace();
        }
    }
}
