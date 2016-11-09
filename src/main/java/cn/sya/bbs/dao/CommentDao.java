package cn.sya.bbs.dao;

import java.util.List;
import java.util.Map;

import cn.sya.bbs.entity.Comment;

/**
 * @author Android
 * 回贴Dao接口
 */
public interface CommentDao {
	List<Map<String, Object>> listCommnetByPostID(String postID);
	void saveComment(Comment comment);

}
