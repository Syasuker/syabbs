package cn.sya.bbs.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.sya.bbs.entity.Comment;
import cn.sya.bbs.web.JsonResult;

public class TestJackson {
	
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String json = mapper.writeValueAsString(new JsonResult<Comment>(new Comment()));
			System.out.println(json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
