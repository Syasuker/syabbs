package cn.sya.bbs.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 将秒数转换为
 * @author Android
 *
 */
public class DateConvert {
	public String rule = "yyyy-MM-dd HH:mm:ss";
	
	public DateConvert() {
		super();
	}

	public DateConvert(String rule) {
		super();
		this.rule = rule;
	}

	public String Convert(Long time){
		Date date= new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat(rule);
		String dateStr = sdf.format(date);
		return dateStr;
	}
	
	public static void main(String[] args) {
		//测试时间转换工具类
		Long now = System.currentTimeMillis();
		System.out.println(now);
		Date date= new Date(1377295989000L);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdf.format(date);
		System.out.println(dateStr);
	}

}
