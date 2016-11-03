package cn.sya.bbs.web;

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
import cn.sya.bbs.service.PostService;
import cn.sya.bbs.util.JackSon;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
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
		String PostID = request.getParameter("PostID");
		
		Post post = postService.loadPost(PostID);
		
		//测试jackson
//		System.out.println(JackSon.toJson(postJson));
		String jsonResult = JackSon.toJson(new JsonResult<Post>(post));
		
		request.setAttribute("jsonResult", jsonResult);
		request.setAttribute("post", post);
		return "post";
	}

}
