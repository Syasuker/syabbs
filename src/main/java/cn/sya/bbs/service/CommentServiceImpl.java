package cn.sya.bbs.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sya.bbs.dao.CommentDao;
import cn.sya.bbs.dao.PostDao;
import cn.sya.bbs.dao.UserDao;
import cn.sya.bbs.entity.Comment;
import cn.sya.bbs.entity.Post;
import cn.sya.bbs.entity.User;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	private static final long serialVersionUID = 6658465075888068410L;
	
	@Autowired
	private CommentDao commentDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private PostDao postDao;
	
	public CommentServiceImpl() {
	}

	public Comment addComment(String body, String postID, String userID) {
		//MySQL要求限制 TEXT L+2个字节(+2是ROM签名)，其中L < 2的16次方 FFFF
		if (body.getBytes().length >= 0xFFFF+2) {
			throw new ServiceException("请不要大于2万个字----0xFFFF+2");
		}
		if (body==null && body.trim().isEmpty()) {
			throw new ServiceException("输入内容不能为空");
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
		Post post = null;
		try {
			post = postDao.findPostById(postID);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("主贴不存在");
		}
		if (post==null) {
			throw new ServiceException("主贴不存在");
		}
		
		Comment comment = new Comment();
		String id = UUID.randomUUID().toString();
		String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		comment.setId(id);
		comment.setPostID(postID);
		comment.setStatus("1");
		comment.setUser(user);
		comment.setBody(body);
		comment.setCreateTime(now);
		comment.setModifyTime(now);
		//提交评论
		commentDao.saveComment(comment);
		//将评论及时显示
		//TODO 数据库查询返回
		return comment;
	}

	public List<Map<String, Object>> listCommnet(String postID) {
    	if (postID==null||postID.trim().isEmpty()) {
			throw new ServiceException("贴子ID不能为空");
		}
    	    	
    	List<Map<String, Object>> comments = commentDao.listCommnetByPostID(postID);
		return comments;
	}

}
