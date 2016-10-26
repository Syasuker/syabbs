package cn.sya.bbs.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sya.bbs.dao.PostDao;
import cn.sya.bbs.dao.UserDao;
import cn.sya.bbs.entity.Post;
import cn.sya.bbs.entity.User;

@Service("postService")
public class PostServiceImpl implements PostService {
	private static final long serialVersionUID = 4877470087288006758L;
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private PostDao postDao;

	public Post sendPost(String title, String body, String plate, String userID) throws ServiceException {
		if(title==null||title.trim().isEmpty()){
			throw new ServiceException("标题不能为空");
		}
		//标题小于15个汉字
		if (title.length()>15) {
			throw new ServiceException("标题不能超过15个字符");
		}
		
		User user = null;
		try {
			user = userDao.findUserById(userID);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("用户没有权限");
		}
		if (user==null) {
			throw new ServiceException("用户没有权限");
		}
		Post post = new Post();
		String post_id = UUID.randomUUID().toString();
//		Long now = System.currentTimeMillis();
		String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		post.setPost_id(post_id);
		post.setPlate_id(plate);
		post.setUser(user);
		post.setTitle(title);
		post.setStatus("1");
		post.setBody(body);
		post.setCreateTime(now);
		post.setLastModifyTime(now);
		
		postDao.savePost(post);
		return postDao.findPostById(post_id);
	}
	
	public Post loadPost(String postId) throws ServiceException {
		
    	if (postId==null||postId.trim().isEmpty()) {
			throw new ServiceException("贴子ID不能为空");
		}
    	Post post=null;
		post = postDao.findPostById(postId);
    	
    	if (post==null) {
			throw new ServiceException("贴子不存在");
		}
		return post;
	}
	
	public List<Map<String, Object>> listPost(String plateID) throws ServiceException {
/*
  	| id                                   
	| plate 
	| title                   
	| body                
	| modTime       
	| author 
 */
		List<Map<String, Object>> posts=null;
		if (plateID==null||plateID.trim().isEmpty()) {
			throw new ServiceException("板块ID不能为空");
		}
		
		posts = postDao.listPostByPlateID(plateID);
		if (posts==null) {
			throw new ServiceException("板块不存在");
		}
		
		return posts;
	}


}
