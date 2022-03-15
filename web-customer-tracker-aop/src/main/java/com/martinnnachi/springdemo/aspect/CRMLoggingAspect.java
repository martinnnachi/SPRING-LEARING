package com.martinnnachi.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

import static com.martinnnachi.springdemo.ConsoleColours.*;

@Aspect
@Component
public class CRMLoggingAspect {

    // setup logger
    Logger logger = Logger.getLogger( getClass().getName() );

    // setup pointcut declarations
    @Pointcut("execution(* com.martinnnachi.springdemo.controller.*.*(..))")
    private void forControllerPackage() {

    }

    @Pointcut("execution(* com.martinnnachi.springdemo.service.*.*(..))")
    private void forServicePackage() {

    }

    @Pointcut("execution(* com.martinnnachi.springdemo.dao.*.*(..))")
    private void forDaoPackage() {

    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {

    }

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {

        String theMethod = joinPoint.getSignature().toShortString();
        logger.info( "=====>>>> in @Before: calling method: " + BLUE_BOLD_BRIGHT + theMethod + RESET );

        // display the arguments to the method

        // get the arguments
        Object[] args = joinPoint.getArgs();

        // loop through and display args
        for (Object temArg : args) {
            logger.info( "=====>>>> argument: " + CYAN_BOLD_BRIGHT + temArg + RESET );
        }
    }

    // add @AfterReturning advice
    @AfterReturning(value = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String theMethod = joinPoint.getSignature().toShortString();
        logger.info( "=====>>>> in @AfterReturning: calling method: " + PURPLE_BOLD_BRIGHT + theMethod + RESET );

        logger.info( "=====>>>> result: " + PURPLE_BOLD_BRIGHT + result + RESET );
    }
}
