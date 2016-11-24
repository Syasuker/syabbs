package cn.sya.bbs.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.sya.bbs.dao.CommentDao;
import cn.sya.bbs.dao.PostDao;
import cn.sya.bbs.dao.UserDao;
import cn.sya.bbs.entity.Comment;
import cn.sya.bbs.entity.Post;
import cn.sya.bbs.service.CommentService;
import cn.sya.bbs.service.PostService;

public class TestComment {
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
	public void saveComment(){
		CommentDao commentDao = applicationContext.getBean("commentDao",CommentDao.class);
		UserDao userDao= applicationContext.getBean("userDao",UserDao.class);
		
		Comment comment = new Comment();
		String id = UUID.randomUUID().toString();
		comment.setId(id);
		comment.setUser(userDao.findUserById("e52342ab-15a5-4b24-8b0a-98affdc8dcc7"));
		comment.setPostID("f2a3b66a-52c4-4f61-9aca-17f70a5576da");
		comment.setBody("<p>新人报道2333</p>");
		comment.setStatus("1");
		String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		comment.setCreateTime(now);
		comment.setModifyTime(now);
		
		commentDao.saveComment(comment);
		System.out.println("存入Comment完成");
	}

	@Test
	//测试根据id找
	public void findPostById(){
		PostDao postDao = applicationContext.getBean("postDao", PostDao.class);
		Post post = postDao.findPostById("d74c39c3-3cea-4007-b4d5-300d8a179a9e");
		
		System.out.println(post);
	}
	
	@Test
	public void listCommnetByPostID(){
		CommentDao commentDao = applicationContext.getBean("commentDao",CommentDao.class);
		List<Map<String, Object>> comments = commentDao.listCommnetByPostID("6ba0155c-8329-465a-8c31-880d0bf1da26");
		for (Map<String, Object> map : comments) {
			System.out.println(map);
		}
	}
	
	
	/**
	 * 测试Service
	 */
	@Test
	public void testloadPost(){
		PostService postService = applicationContext.getBean("postService", PostService.class);
		System.out.println(postService);
		Post post = postService.loadPost("d74c39c3-3cea-4007-b4d5-300d8a179a9e");
		System.out.println(post);
	}
	@Test
	public void addComment(){
		CommentService commentService = applicationContext.getBean("commentService" ,CommentService.class);
		commentService.addComment("<p>新人报道2333</p>", "f2a3b66a-52c4-4f61-9aca-17f70a5576da", "e52342ab-15a5-4b24-8b0a-98affdc8dcc7");
		System.out.println("回复评论成功");
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
