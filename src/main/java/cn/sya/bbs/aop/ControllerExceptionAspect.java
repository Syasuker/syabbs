package cn.sya.bbs.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.sya.bbs.web.JsonResult;

/*
 * 利用Spring AOP统一处理异常
 */
@Component
@Aspect
public class ControllerExceptionAspect {
	@Around("bean(accountController)||bean(postController)")
	public Object process(ProceedingJoinPoint joinPoint){
		//抓取反射的方法名
		String AOPmethod =	joinPoint.getSignature().getName();
		//获取请求
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        
        String url = request.getRequestURL().toString();
        //请求方式
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        
        
        
		try {
			System.out.println("开始调用控制器");
			Object val = joinPoint.proceed();
			return val;
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if ("showPost".equals(AOPmethod)) {
				//绑定一场信息到error.jsp
				request.setAttribute("Emsg", e.getMessage());
				return "error";
			}
			return new JsonResult<Object>(JsonResult.ERROR,e.getMessage());
		}
	}

}
