package cn.sya.bbs.test;

import java.io.UnsupportedEncodingException;

/**
 * @author Android
 *测试Java String utf-16占用的大小
 */
public class TestString {
	//MySQL要求限制 TEXT L+2个字节(+2是ROM签名)，其中L < 2的16次方 FFFF
	public static void main(String[] args) {
		String test1 = "测试ab测试";
		byte[] b = null;
		try {
			b = test1.getBytes("utf-16");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(b.length);
		
		System.out.println();
	}

}
