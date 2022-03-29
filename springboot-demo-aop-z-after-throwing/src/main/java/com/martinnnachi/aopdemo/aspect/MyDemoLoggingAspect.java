package com.martinnnachi.aopdemo.aspect;

import com.martinnnachi.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001b[32m";

    @AfterThrowing(pointcut = "execution(* com.martinnnachi.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {

        // print out which method we're advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println( "\n=======>>>> Executing AfterThrowing on method: " + ANSI_GREEN + method + ANSI_RESET );

        // log the exception
        System.out.println( "\n=======>>>> The exception is: " + ANSI_RED + theExc + ANSI_RESET );
    }

    // add new advice for AfterReturning on the findAccounts() method
    @AfterReturning(pointcut = "execution(* com.martinnnachi.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        // print out which method we're advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println( "\n=======>>>> Executing AfterReturning on method: " + ANSI_GREEN + method + ANSI_RESET );

        // print out results of the method call
        System.out.println( "\n=======>>>> Result is: " + ANSI_GREEN + result + ANSI_RESET + "\n" );

        // let's post-process the data...modify it

        // convert the account names to uppercase
        convertAccountNamesToUpperCase( result );
        System.out.println( "\n=======>>>> Result is: " + ANSI_GREEN + result + ANSI_RESET + "\n" );

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        // loop through accounts
        for (Account tempAccount : result) {
            // get uppercase version of the names
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the names on the account
            tempAccount.setName( theUpperName );
        }
    }


    @Before("com.martinnnachi.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println( ANSI_CYAN + "\n=======>>>> Executing @Before advice on methods" + ANSI_RESET );

        // display the method signature
        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();

        System.out.println( ANSI_RED + "Method: " + methodSig + ANSI_RESET );

        // display method arguments


        // get args
        Object[] args = joinPoint.getArgs();

        // loop through the args
        for (Object temArg : args) {
            System.out.println( temArg );
            if (temArg instanceof Account account) {

                System.out.println( "Account name: " + account.getName() );
                System.out.println( "Account level: " + account.getLevel() );
            }
        }


    }


}
