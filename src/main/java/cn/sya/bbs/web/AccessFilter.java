package cn.sya.bbs.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessFilter implements Filter{

	public AccessFilter() {
	}

	public void init(FilterConfig filterConfig) throws ServletException {
//		System.out.println("初始化拦截器");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		System.out.println("拦截器检查");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		StringBuffer path = req.getRequestURL();
		
		System.out.println(req.getHeader("User-Agent"));
//		System.out.println(req.getHeader("x-forwarded-for"));
//		System.out.println(req.getHeader("WL-Proxy-Client-IP"));
//		System.out.println(req.getHeader("Proxy-Client-IP"));
//		System.out.println(req.getHeader("HTTP_CLIENT_IP"));
//		System.out.println(req.getHeader("HTTP_X_FORWARDED_FOR"));
		System.out.println(req.getHeaderNames().toString());
		
		String url = path.toString();
//		System.out.println(url);
		//拦截无指向
		if (url.endsWith("syabbs/")) {
			String login = url+"list.html?"+System.currentTimeMillis();
			resp.sendRedirect(login);
			return;
		}
		chain.doFilter(req, resp);
	}
	
	

	public void destroy() {
		
	}

}
