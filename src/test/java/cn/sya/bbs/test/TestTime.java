package cn.sya.bbs.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Android
 *　测试字段代码转换
 */
public class TestTime {

	public TestTime() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
		Long now = System.currentTimeMillis();
		System.out.println(now);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(now);
		String nowStr = sdf.format(date);
		System.out.println(nowStr);

	}

}
