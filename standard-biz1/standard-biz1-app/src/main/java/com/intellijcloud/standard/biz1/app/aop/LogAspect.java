package com.intellijcloud.standard.biz1.app.aop;

import com.intellijcloud.standard.common.utils.LogWorker;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author patrick
 */
@Aspect
@Component
@Slf4j
public class LogAspect {
    @Pointcut("execution(* com.intellijcloud.standard.biz1.app.service.*.*(..))")
    public void pointcutExpression() {

    }


    @Before("pointcutExpression()")
    public void preMethod(JoinPoint joinPoint) {
        LogWorker.log(log,"前置方法","");
    }


    @After("pointcutExpression()")
    public void afterMethod(JoinPoint joinPoint) {
        LogWorker.log(log,"后置通知","");
    }


    @AfterReturning(value = "pointcutExpression()", returning = "returnValue")
    public void afterRunningMethod(JoinPoint joinPoint, Object returnValue) {
        LogWorker.log(log,"返回通知执行，执行结果：" ,"");
    }


    @AfterThrowing(value = "pointcutExpression()", throwing = "e")
    public void afterThrowingMethod(JoinPoint joinPoint, Exception e) {
        System.out.println("异常通知, 出现异常 ：" + e);
    }


    @Around("pointcutExpression()")
    public Object aroundMethod(ProceedingJoinPoint pjd) {

        Object result = null;
        String methodName = pjd.getSignature().getName();

        try {
            //前置通知
            System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
            //执行目标方法
            result = pjd.proceed();
            //返回通知
            System.out.println("The method " + methodName + " ends with " + result);
        } catch (Throwable e) {
            //异常通知
            System.out.println("The method " + methodName + " occurs exception:" + e);
            throw new RuntimeException(e);
        }
        //后置通知
        System.out.println("The method " + methodName + " ends");

        return result;
    }
}
