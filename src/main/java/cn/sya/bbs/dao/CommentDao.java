package cn.sya.bbs.dao;

import java.util.List;
import java.util.Map;

/**
 * @author Android
 * 回贴Dao接口
 */
public interface CommentDao {
	List<Map<String, Object>> listCommnetByPostID(String postID);

}
