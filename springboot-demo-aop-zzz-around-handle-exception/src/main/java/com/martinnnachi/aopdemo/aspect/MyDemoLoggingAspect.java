package com.martinnnachi.aopdemo.aspect;

import com.martinnnachi.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)//
public class MyDemoLoggingAspect {

    Logger logger = LoggerFactory.getLogger( getClass().getName() );

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001b[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_BLACK = "\u001B[30m";

    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    @Around("execution(* com.martinnnachi.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // print out the method we're advising on
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info( "\n=======>>>> Executing @Around on method: " + ANSI_BLUE + method + ANSI_RESET );

        // get beginning timestamp
        long begin = System.currentTimeMillis();

        // execute the code
        Object result;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            // log the exception
            logger.warn( e.getMessage() );

            // give the user a custom message
//            result = ANSI_BLACK + ANSI_RED_BACKGROUND + "Major accident! Private AOP rescue on the way!" + ANSI_RESET;

            // rethrow exception
            throw e;
        }

        // get the ending timestamp
        long end = System.currentTimeMillis();

        // compute duration
        long duration = end - begin;
        logger.info( "\n=======>>>> Duration: " + duration / 1000 + " seconds" );

        return result;
    }

    @After("execution(* com.martinnnachi.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

        // print out which method we're advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info( "\n=======>>>> Executing After (Finally) on method: " + ANSI_BLUE + method + ANSI_RESET );


    }

    @AfterThrowing(pointcut = "execution(* com.martinnnachi.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {

        // print out which method we're advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info( "\n=======>>>> Executing AfterThrowing on method: " + ANSI_GREEN + method + ANSI_RESET );

        // log the exception
        logger.info( "\n=======>>>> The exception is: " + ANSI_RED + theExc + ANSI_RESET );
    }

    // add new advice for AfterReturning on the findAccounts() method
    @AfterReturning(pointcut = "execution(* com.martinnnachi.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        // print out which method we're advising on
        String method = joinPoint.getSignature().toShortString();
        logger.info( "\n=======>>>> Executing AfterReturning on method: " + ANSI_GREEN + method + ANSI_RESET );

        // print out results of the method call
        logger.info( "\n=======>>>> Result is: " + ANSI_GREEN + result + ANSI_RESET + "\n" );

        // let's post-process the data...modify it

        // convert the account names to uppercase
        convertAccountNamesToUpperCase( result );
        logger.info( "\n=======>>>> Result is: " + ANSI_GREEN + result + ANSI_RESET + "\n" );

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
        logger.info( ANSI_CYAN + "\n=======>>> Executing @Before advice on methods" + ANSI_RESET );

        // display the method signature
        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();

        logger.info( ANSI_RED + "Method: " + methodSig + ANSI_RESET );

        // display method arguments


        // get args
        Object[] args = joinPoint.getArgs();

        // loop through the args
        for (Object temArg : args) {
            logger.info( temArg.toString() );
            if (temArg instanceof Account account) {

                logger.info( "Account name: " + account.getName() );
                logger.info( "Account level: " + account.getLevel() );
            }
        }


    }


}