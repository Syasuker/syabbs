package cn.sya.bbs.service;

import java.io.Serializable;

import cn.sya.bbs.entity.Comment;

public interface CommentService extends Serializable {
	public Comment addComment(String body, String postID, String userID);

}
