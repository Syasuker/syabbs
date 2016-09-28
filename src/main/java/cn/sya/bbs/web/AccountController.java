package cn.sya.bbs.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sya.bbs.entity.User;
import cn.sya.bbs.service.UserService;
import cn.sya.bbs.util.Md5;


@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private UserService userService; 
	
	@RequestMapping("/regist.sya")
	@ResponseBody
	public JsonResult<User> regist(String name,String password,String mobile){
		System.out.println("regist.sya");
		User user = userService.register(name, password, mobile);
		return new JsonResult<User>(user);
	}
	
	
	@RequestMapping("/login.sya")
	@ResponseBody
	public JsonResult<User> login(String name,String password,HttpServletRequest req,HttpServletResponse resp){
		System.out.println("login.sya");
/*		String name = req.getParameter("name");
		String password = req.getParameter("password");*/
//		String serverCode = (String) req.getSession().getAttribute("code");
//		if (serverCode==null||!serverCode.equalsIgnoreCase(code)) {
//			return new JsonResult<User>("验证码无效");
//		}

		User user = userService.login(name, password);
		//保存Cookie -- token
		//利用UserAgent+时间 创建Token  不同的浏览器使用不同的值
		String UserAgent = req.getHeader("User-Agent");
		//当前时间
		long now = System.currentTimeMillis();
		String token = Md5.saltMd5(UserAgent+now);
		Cookie cookie = new Cookie("token", now+"|"+token);
		//			设置Cookie作用范围
		cookie.setPath("/");
		resp.addCookie(cookie);
		return new JsonResult<User>(user);
	}
}
