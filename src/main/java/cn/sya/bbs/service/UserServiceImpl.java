package cn.sya.bbs.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sya.bbs.dao.UserDao;
import cn.sya.bbs.entity.User;
import cn.sya.bbs.util.Md5;

@Service("userService")
public class UserServiceImpl implements UserService {
	private static final long serialVersionUID = -3898088190430435866L;
	
	@Autowired
	UserDao dao;
	public UserServiceImpl() {
	}
	public static void main(String[] args) {
	}


	public User register(String name, String password, String mobile) throws ServiceException {
		String rule = "^\\w{3,10}$";
		if (name==null||name.trim().isEmpty()) {
			throw new ServiceException("用户名不能为空");
		}
		if (!name.matches(rule)) {
			throw new ServiceException("用户名不符合要求!");
		}
		if (password==null || password.trim().isEmpty()) {
			throw new ServiceException("密码不能为空");
		}
		if (!password.matches(rule)) {
			throw new ServiceException("密码不符合要求!");
			
		}
		
		rule = "^\\d{11}$";
		if (!mobile.matches(rule)) {
			throw new ServiceException("手机号应为11位!");
		}
		// 检查用户名是否冲突
		User user = dao.findUserByName(name);
		if (user!=null) {
			throw new ServiceException("用户名已存在");
		}
		
		String id = UUID.randomUUID().toString();
		password = Md5.saltMd5(password);
		user = new User(id, name, password, mobile, "");
		dao.saveUser(user);
		return user;
		
	}
	
	public User login(String name, String password) throws NameOrPasswordException {
		
		//入口参数检查
		if(name==null || name.trim().isEmpty()){
			throw new NameOrPasswordException("用户名不能为空");
		}
		if (password==null || password.trim().isEmpty()) {
			throw new NameOrPasswordException("密码不能为空");
		}
		//从业务层查询用户信息
		User user = dao.findUserByName(name);
		if (user==null) {
			throw new NameOrPasswordException("用户名或密码错误");
		}
		if (user.getPassword().equals(Md5.md5(password)) || user.getPassword().equals(Md5.saltMd5(password))) {
			//清理加密的密码
			user.setPassword("");
			return user;//登录成功
		}
		throw new NameOrPasswordException("用户名或密码错误");
	}

}
