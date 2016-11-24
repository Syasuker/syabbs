package cn.sya.bbs.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import cn.sya.bbs.entity.Post;

public interface PostService extends Serializable {
	public Post sendPost(String title, String body,String plate,String userID)throws ServiceException;
	public Post loadPost(String postId)throws ServiceException;
//	只获取贴子ID 作者和时间即可
	public List<Map<String,Object>> listPost(String plateID,String pageStart,String Pagesize)throws ServiceException;
}
