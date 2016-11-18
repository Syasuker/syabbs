package cn.sya.bbs.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.sya.bbs.entity.Post;
import cn.sya.bbs.service.CommentService;
import cn.sya.bbs.service.PostService;
import cn.sya.bbs.util.JackSon;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	@Autowired
	private CommentService commentService; 
	
//	syabbs/post/list.sya
	@RequestMapping("/list.sya")
	@ResponseBody
	public JsonResult<List<Map<String, Object>>> listPost(String plateID){
//		System.out.println("listPost Controller");
		List<Map<String, Object>> posts = postService.listPost(plateID);
		return new JsonResult<List<Map<String, Object>>>(posts);
	}
	
//	syabbs/post/save.sya
	@RequestMapping("/save.sya")
	@ResponseBody
	public JsonResult<Post> savePost(HttpServletRequest req){
//		System.out.println("sendPost Controller");
		
		String title = req.getParameter("title");
		String body = req.getParameter("body");
		String plate = req.getParameter("plate");
		String userID = req.getParameter("userID");
		
		Post post = postService.sendPost(title, body, plate, userID);
		
		return new JsonResult<Post>(post);
	}
	
	
//	syabbs/post/post.sya
	@RequestMapping("/post.sya")
	public String showPost(HttpServletRequest request){
//		System.out.println("showPost");
//		System.out.println("==================getRequestURL:"+request.getRequestURL().toString());
		String postID = request.getParameter("PostID");
		//展示贴子
		Post post = postService.loadPost(postID);
//		展示评论列表
		List<Map<String, Object>> comments = commentService.listCommnet(postID);
		
//		新建一个Map封装Comment和Post
		
		Map<String, Object> postCommentsMap = new HashMap<String, Object>();
		postCommentsMap.put("post", post);
		postCommentsMap.put("comments", comments);
		
		//测试jackson
		String jsonResult = JackSon.toJson(new JsonResult<Map<String, Object>>(postCommentsMap));
//		System.out.println(jsonResult);
				
		request.setAttribute("jsonResult", jsonResult);
		request.setAttribute("post", post);
		request.setAttribute("comments", comments);
		
		return "post";
	}

}
