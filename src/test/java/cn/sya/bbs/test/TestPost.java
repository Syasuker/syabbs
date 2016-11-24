package cn.sya.bbs.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sya.bbs.dao.PostDao;
import cn.sya.bbs.dao.UserDao;
import cn.sya.bbs.entity.Post;
import cn.sya.bbs.service.PostService;

public class TestPost {
	ApplicationContext applicationContext= null;
	
	@Before
	public void init(){
		applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml","spring-web.xml");
	}
	@Test
	public void testMapScanner(){
		Object obj = applicationContext.getBean("mapperScanner");
		System.out.println(obj);
	}
	/*
	 * 测试DAO
	 */
	@Test
	public void savePost(){
		PostDao postDao= applicationContext.getBean("postDao",PostDao.class);
		UserDao userDao= applicationContext.getBean("userDao",UserDao.class);
		Post post = new Post();
		String post_id = UUID.randomUUID().toString();
		post.setPost_id(post_id);
		post.setUser(userDao.findUserById("e52342ab-15a5-4b24-8b0a-98affdc8dcc7"));
		post.setTitle("大家好!!!!早上好!");
		post.setBody("<p>新人报道</p>");
		post.setStatus("1");
		post.setPlate_id("1");
		String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		post.setCreateTime(now);
		post.setLastModifyTime(now);
		
		postDao.savePost(post);
		System.out.println("存入数据完成");
	}

	@Test
	//测试根据id找
	public void findPostById(){
		PostDao postDao = applicationContext.getBean("postDao", PostDao.class);
		Post post = postDao.findPostById("d74c39c3-3cea-4007-b4d5-300d8a179a9e");
		
		System.out.println(post);
	}
	
	//测试分页函数
	@Test
	public void ListPost(){
		PostDao postDao = applicationContext.getBean("postDao", PostDao.class);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("plate_id", "1");
		map.put("start", 2);
		map.put("length", 1);
		List<Map<String, Object>> posts = postDao.listPostByPlateID(map);
		for (Map<String, Object> post : posts) {
			System.out.println(post);
		}
	}
	
	
	/**
	 * 测试Service
	 */
	@Test
	public void listPostServiceTest(){
		PostService postService = applicationContext.getBean("postService", PostService.class);
		System.out.println(postService);
		
		List<Map<String, Object>> posts = postService.listPost("1", "2", "1");
		for (Map<String, Object> map : posts) {
			System.out.println(map);
		}
	}
	@Test
	public void testloadPost(){
		PostService postService = applicationContext.getBean("postService", PostService.class);
		System.out.println(postService);
		Post post = postService.loadPost("f2a3b66a-52c4-4f61-9aca-17f70a5576da");
		System.out.println(post);
	}
	@Test
	public void TestSendPost(){
		PostService postService = applicationContext.getBean("postService", PostService.class);
		postService.sendPost("打击哈", "", "1", "e52342ab-15a5-4b24-8b0a-98affdc8dcc7");
	}
	
	public static void main(String[] args) {
		//测试时间转换工具类
		Long now = System.currentTimeMillis();
		System.out.println(now);
		Date date= new Date(1377295989000L);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdf.format(date);
		System.out.println(dateStr);
	}

}
