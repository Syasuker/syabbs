package cn.sya.bbs.dao;

import java.util.List;
import java.util.Map;

import cn.sya.bbs.entity.Post;

/**
 * 帖子数据库总接口
 * @author Android
 *
 */
public interface PostDao {
	void savePost(Post post);
	Post findPostById(String post_id);
	List<Map<String, Object>> listPostByPlateID(Map<String, Object> WithPlateID);
	
}
