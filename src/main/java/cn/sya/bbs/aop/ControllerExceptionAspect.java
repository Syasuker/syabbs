package cn.sya.bbs.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import cn.sya.bbs.web.JsonResult;

/*
 * 利用Spring AOP统一处理异常
 */
@Component
@Aspect
public class ControllerExceptionAspect {
	@Around("bean(accountController)")
	public Object process(ProceedingJoinPoint joinPoint){
		try {
			System.out.println("开始调用控制器");
			Object val = joinPoint.proceed();
			return val;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new JsonResult<Object>(JsonResult.ERROR,e.getMessage());
		}
	}

}
