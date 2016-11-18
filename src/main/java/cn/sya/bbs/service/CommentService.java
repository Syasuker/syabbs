package cn.sya.bbs.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.sya.bbs.entity.Comment;

public interface CommentService extends Serializable {
	/**
	 * @param body
	 * @param postID
	 * @param userID
	 * @return 返回添加的贴子
	 */
	public Comment addComment(String body, String postID, String userID);
	/**
	 * @param postID
	 * @return 返回评论集合
	 */
	public List<Map<String, Object>> listCommnet(String postID);

}
