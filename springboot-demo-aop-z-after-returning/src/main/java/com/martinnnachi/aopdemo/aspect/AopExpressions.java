package com.martinnnachi.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* com.martinnnachi.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {
    }

    // create pointcut for getter methods
    @Pointcut("execution(* com.martinnnachi.aopdemo.dao.*.get*(..))")
    public void getter() {
    }

    // create pointcut for setter methods
    @Pointcut("execution(* com.martinnnachi.aopdemo.dao.*.set*(..))")
    public void setter() {
    }

    // create pointcut: include package ... exclude getters/setters
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {
    }

}
