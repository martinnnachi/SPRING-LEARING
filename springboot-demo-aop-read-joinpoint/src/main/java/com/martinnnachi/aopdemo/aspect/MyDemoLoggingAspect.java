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

    @Before("com.martinnnachi.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println( "\n=======>>> Executing @Before advice on methods" );

        // display the method signature
        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();

        System.out.println( "Method: " + methodSig );

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
