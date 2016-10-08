package cn.sya.bbs.web;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sya.bbs.entity.User;
import cn.sya.bbs.service.UserService;
import cn.sya.bbs.util.CreateImageCode;
import cn.sya.bbs.util.ImgCode;
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
		//TODO 清理返回的密码
		return new JsonResult<User>(user);
	}
	
	
	@RequestMapping("/login.sya")
	@ResponseBody
	public JsonResult<User> login(String name,String password,String code,HttpServletRequest req,HttpServletResponse resp){
		System.out.println("login.sya");
/*		String name = req.getParameter("name");
		String password = req.getParameter("password");*/
//		String serverCode = (String) req.getSession().getAttribute("code");
//		if (serverCode==null||!serverCode.equalsIgnoreCase(code)) {
//			return new JsonResult<User>("验证码无效");
//		}
		
		//验证验证码
		String serverCode = (String) req.getSession().getAttribute("code");
		if (serverCode==null||!serverCode.equalsIgnoreCase(code)) {
			return new JsonResult<User>("验证码错误");
		}

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
	
	//	syabbs/account/code.sya
	@RequestMapping(value="/code.sya", produces="image/png")
	@ResponseBody
	public byte[] code(HttpServletRequest req){
		byte[] buf = null;
		try {

			Map<String, Object> codeMap = new ImgCode().code();

			String code = (String)codeMap.get("code");
			System.out.println(code);
			//将验证码答案绑定到Session上
			req.getSession().setAttribute("code", code);
			
			BufferedImage img = (BufferedImage)codeMap.get("image");
			//创建一个Byte输出流
			ByteArrayOutputStream out = new ByteArrayOutputStream();

			ImageIO.write(img, "png", out);
			buf = out.toByteArray();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return buf;
	}
	//验证码验证方法
	@RequestMapping("checkCode.sya")
	@ResponseBody
	public JsonResult<Boolean> checkCode(String code ,HttpServletRequest req){
		System.out.println(code);
		String serverCode = (String) req.getSession().getAttribute("code");
		System.out.println(serverCode);
		if (serverCode==null) {
			return new JsonResult<Boolean>("验证码错误");
		}
		//不考虑大小写
		if (serverCode.equalsIgnoreCase(code)) {
			return new JsonResult<Boolean>(true);
		}
		return new JsonResult<Boolean>("验证码错误");
	}
	
	
	
	//	syabbs/account/code2.sya
	@RequestMapping(value="/code2.sya", produces="image/png")
	@ResponseBody
	public byte[] code2(){
		byte[] buf = null;
		try {
			
			CreateImageCode vCode = new CreateImageCode(80, 30);
			
			//创建一个Byte输出流
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			
			vCode.write(out);
			System.out.println(vCode.getCode());
			buf = out.toByteArray();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buf;
	}
}
