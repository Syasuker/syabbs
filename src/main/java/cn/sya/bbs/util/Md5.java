package cn.sya.bbs.util;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

public class Md5 {
	public static final String salt="cn.sya.bbs";
	
	public static String saltMd5(String str){
		try {
			//将string-->byte
			byte[] data = str.getBytes("utf-8");
			//设置md5算法
			MessageDigest md = MessageDigest.getInstance("MD5");
			//添加数据
			md.update(data);
			//加入独特的盐混淆
			md.update(salt.getBytes("utf-8"));
			//计算md5值
			byte[] md5 = md.digest();
			//使用Base64编码
			String code = Base64.encodeBase64String(md5);
			return code;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static String md5(String str){
		try {
			byte[] data = str.getBytes("utf-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(data);
			data = md.digest();
			String code = Base64.encodeBase64String(data);
			return code;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
