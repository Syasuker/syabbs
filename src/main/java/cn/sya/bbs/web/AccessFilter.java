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

import cn.sya.bbs.entity.Post;
import cn.sya.bbs.util.JackSon;

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
		
		String servletPath = req.getServletPath();
//		getServletPath:/postID/5989b6b0-a440-4cb4-98ee-9be90962e611
//		getContextPath:/syabbs
		
//		System.out.println("getServletPath:"+req.getServletPath());
//		System.out.println("getContextPath:"+req.getContextPath());
		
		
		System.out.println(req.getHeader("User-Agent"));
//		System.out.println(req.getHeader("x-forwarded-for"));
//		System.out.println(req.getHeader("WL-Proxy-Client-IP"));
//		System.out.println(req.getHeader("Proxy-Client-IP"));
//		System.out.println(req.getHeader("HTTP_CLIENT_IP"));
//		System.out.println(req.getHeader("HTTP_X_FORWARDED_FOR"));
//		System.out.println(req.getHeaderNames().toString());
		//获取url
		String url = path.toString();
		System.out.println(url);
		//   http://localhost:8080/syabbs
		String rootPath = url.split(servletPath)[0];
		System.out.println("rootPath:"+rootPath);
		
		
		//对PostID转发
		//当前路径http://localhost:8080/syabbs/postID/5989b6b0-a440-4cb4-98ee-9be90962e611
		//目标路径http://localhost:8080/syabbs/post/post.sya?PostID=5989b6b0-a440-4cb4-98ee-9be90962e611
//		System.out.println(url.substring(0,url.lastIndexOf("/")));
		if (url.substring(0,url.lastIndexOf("/")).endsWith("postID")) {
			String postID = url.substring(url.lastIndexOf("/")+1, url.length());
			System.out.println(postID);
			//实现转发
			//转发的基础路径是当前路径;加斜线是根目录也就是rootPath;
			String uri = "/post/post.sya?PostID="+postID;
			System.out.println(uri);
			req.getRequestDispatcher(uri).forward(req, resp);
//			String getPost = "http://localhost:8080/syabbs/post/post.sya?PostID=5989b6b0-a440-4cb4-98ee-9be90962e611";
//			resp.sendRedirect(getPost);
			return;
		}
		
		
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
