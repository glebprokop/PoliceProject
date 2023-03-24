package com.forensic.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BusinessLogicAspect {

    /**
    * Log4j logger used in project now. In the future it may be other realisation.
    */
    private static final Logger log = Logger.getLogger(BusinessLogicAspect.class);

    /**
     * The {@link Pointcut} used for {@link com.forensic.repository.CRUDRepository} and implemented classes
     */
    @Pointcut("execution(* com.forensic.repository..*(..))")
    public void repositoryPointcut(){
    }

    /**
     * The {@link Pointcut} used for {@link com.forensic.service.CRUDService} and implemented classes
     */
    @Pointcut("execution(* com.forensic.service..*(..))")
    public void servicePointcut(){
    }

    /**
     * Method using for logging of the calls methods in repositories
     *
     * @param jp {@link JoinPoint} join point
     */
    @Before("repositoryPointcut()")
    public void repositoryLoggerBefore(JoinPoint jp){
        String methodSignature = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();

        try {
            log.info("Repository method - " + methodSignature + " - was called.");
        } catch (Throwable throwable) {
            log.error("Exception in method: " + methodSignature +
                    ". Error message: " + throwable.getMessage());
            throwable.printStackTrace();
        }
    }

    /**
     * Method using for logging of the finishing methods in repositories
     *
     * @param jp {@link JoinPoint} join point
     */
    @After("repositoryPointcut()")
    public void repositoryLoggerAfter(JoinPoint jp){
        String methodSignature = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();

        try {
            log.info("Repository method - " + methodSignature + " - was finished.");
        } catch (Throwable throwable) {
            log.error("Exception in method: " + methodSignature +
                    ". Error message: " + throwable.getMessage());
            throwable.printStackTrace();
        }
    }

    /**
     * Method using for logging of the call methods in services
     *
     * @param jp {@link JoinPoint} join point
     */
    @Before("servicePointcut()")
    public void serviceLoggerBefore(JoinPoint jp){
        String methodSignature = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();

        try {
            log.info("Service method - " + methodSignature + " - was called.");
        } catch (Throwable throwable) {
            log.error("Exception in method: " + methodSignature +
                    ". Error message: " + throwable.getMessage());
            throwable.printStackTrace();
        }
    }

    /**
     * Method using for logging of the finishing methods in services
     *
     * @param jp {@link JoinPoint} join point
     */
    @After("servicePointcut()")
    public void serviceLoggerAfter(JoinPoint jp){
        String methodSignature = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();

        try {
            log.info("Service method - " + methodSignature + " - was finished.");
        } catch (Throwable throwable) {
            log.error("Exception in method: " + methodSignature +
                    ". Error message: " + throwable.getMessage());
            throwable.printStackTrace();
        }
    }







}
