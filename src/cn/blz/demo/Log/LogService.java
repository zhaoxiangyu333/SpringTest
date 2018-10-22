package cn.blz.demo.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

@Component
@Aspect
@Order(1)
public class LogService {

    @Before("execution(* cn.blz.demo.order.service.*.*(..)) || execution(* cn.blz.demo.user.service.*.*(..))")
    public void beforeLog(JoinPoint joinPoint) {
        System.out.println("before增强处理------------" + new Date().toString() +
                "   类对象名:" + joinPoint.getTarget() +
                "   方法名:" + joinPoint.getSignature().getName());
    }

    @AfterReturning(returning = "rvt", pointcut = "execution(* cn.blz.demo.order.service.*.*(..)) || execution(* cn.blz.demo.user.service.*.*(..))")
    public void afterReturningLog(JoinPoint joinPoint, Object rvt) {
        System.out.println("afterreturning增强处理-----------" + new Date().toString() +
                "   类对象" + joinPoint.getTarget() +
                "   方法名" + joinPoint.getSignature().getName() +
                "   参数" + Arrays.toString(joinPoint.getArgs()) +
                "   返回值" + rvt);
    }

    @AfterThrowing(throwing = "e", pointcut = "execution(* cn.blz.demo.order.service.*.*(..)) || execution(* cn.blz.demo.user.service.*.*(..))")
    public void afterThrowingLog(JoinPoint joinPoint, Throwable e) {
        System.out.println("afterThrowing增强处理--------------" + new Date().toString() +
                "   类对象" + joinPoint.getTarget() +
                "   方法名" + joinPoint.getSignature().getName() +
                "   参数" + Arrays.toString(joinPoint.getArgs()) +
                "   异常" + e.getMessage());
    }

    @After("execution(* cn.blz.demo.order.service.*.*(..)) || execution(* cn.blz.demo.user.service.*.*(..))")
    public void afterLog(JoinPoint joinPoint) {
        System.out.println("after增强处理------------" + new Date().toString() +
                "   类对象名:" + joinPoint.getTarget() +
                "   方法名:" + joinPoint.getSignature().getName());
    }
}
