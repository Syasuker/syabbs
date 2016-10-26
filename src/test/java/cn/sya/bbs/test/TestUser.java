package cn.sya.bbs.test;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sya.bbs.dao.UserDao;
import cn.sya.bbs.entity.User;

public class TestUser {
	ApplicationContext ac =null;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml","spring-web.xml");
	}
	
	@Test
	public void testMapper(){
		Object obj = ac.getBean("mapperScanner");
		System.out.println(obj);
	}
	@Test
	public void testSaveUser(){
		UserDao dao = ac.getBean("userDao",UserDao.class);
		System.out.println(dao);
		String id = UUID.randomUUID().toString();
		System.out.println(id);
		User user = new User(id, "caocao", "123", "13395478357", "");
		dao.saveUser(user);
	}
	@Test
	public void testfindUserByName(){
		UserDao dao = ac.getBean("userDao",UserDao.class);
		System.out.println(dao);
		System.out.println(dao.findUserByName("zhenji"));
	}
	@Test
	public void testFindUserByid(){
		UserDao dao = ac.getBean("userDao",UserDao.class);
		User user = dao.findUserById("e52342ab-15a5-4b24-8b0a-98affdc8dcc7");
		System.out.println(user);
	}
}
