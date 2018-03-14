package edu.sjsu.cmpe275.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.aspectj.lang.annotation.Around;

import java.io.IOException;

@Aspect
@Order(0)
public class RetryAspect {
    /***
     * Following is a dummy implementation of this aspect.
     * You are expected to provide an actual implementation based on the requirements, including adding/removing advices as needed.
     */
	@Around("execution(public void edu.sjsu.cmpe275.aop.TweetService.*(..))")
	public void dummyAdvice(ProceedingJoinPoint joinPoint) {
		for(int i =1; i<=4; i++) {
			try {
				joinPoint.proceed();
				break;
			}catch (IOException e) {
				if (i > 3) {
					System.out.printf("(503: Service Unavailable) Aborted the execution of the method %s\n", joinPoint.getSignature().getName());
					break;
				}
				System.out.printf("Retrying..... (" + i + ")\n", joinPoint.getSignature().getName());
			}catch (IllegalArgumentException e) {
				System.out.printf("(400: Bad Request) Aborted the execution of the method %s\n", joinPoint.getSignature().getName());
				break;
			}catch (Throwable e) {
				System.out.printf("Aborted the execution of the method %s\n", joinPoint.getSignature().getName());
				break;
			}
		}
	}

}
