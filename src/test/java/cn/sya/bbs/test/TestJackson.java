package cn.sya.bbs.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestJackson {
	
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String json = mapper.writeValueAsString(mapper);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
