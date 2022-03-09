package com.martinnnachi.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.martinnnachi.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    // create pointcut for getter methods
    @Pointcut("execution(* com.martinnnachi.aopdemo.dao.*.get*(..))")
    private void getter() {
    }

    // create pointcut for setter methods
    @Pointcut("execution(* com.martinnnachi.aopdemo.dao.*.set*(..))")
    private void setter() {
    }

    // create pointcut: include package ... exclude getters/setters
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {
    }


    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println( "\n=======>>> Executing @Before advice on add*() methods" );
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println( "\n=======>>> Performing API analytics" );

    }
}
