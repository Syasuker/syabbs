package cn.sya.bbs.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.sya.bbs.entity.Comment;
import cn.sya.bbs.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Autowired
	private CommentService commentService;
	public CommentController() {	}
//	comment/send.sya
	@RequestMapping("/send.sya")
	@ResponseBody
	public JsonResult<Comment> sendComment(HttpServletRequest request){
		
		String postID = request.getParameter("postID");
		String body = request.getParameter("body");
		String userID = request.getParameter("userID");
		
		Comment comment = commentService.addComment(body, postID, userID);
		
		return new JsonResult<Comment>(comment);
	}
	
}
