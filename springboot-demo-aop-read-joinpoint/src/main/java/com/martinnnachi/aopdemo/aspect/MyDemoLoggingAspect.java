package com.martinnnachi.aopdemo.aspect;

import com.martinnnachi.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";

    @Before("com.martinnnachi.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println( ANSI_CYAN + "\n=======>>> Executing @Before advice on methods" + ANSI_RESET );

        // display the method signature
        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();

        System.out.println( ANSI_RED + "Method: " + methodSig + ANSI_RESET);

        // display method arguments


        // get args
        Object[] args = joinPoint.getArgs();

        // loop through the args
        for (Object temArg : args) {
            System.out.println( temArg );
            if (temArg instanceof Account account) {
                // downcast and print Account specifics

                System.out.println( "Account name: " + account.getName() );
                System.out.println( "Account level: " + account.getLevel() );
            }
        }


    }


}
