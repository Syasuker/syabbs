package cn.sya.bbs.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.jasper.tagplugins.jstl.core.Out;

public class ImgCode {
	//字符集
	private String codes = "345678ABCDEFHJKLXYabcdrhnp";
	//验证码图片宽度
	private int width = 80;
	//验证码图片高度
	private int height = 30;
	//字符个数
	private int code_size = 4;
	//字体大小
	private int font_size = 25;
	//设置干扰线
	private int lines = 5;
	
	public ImgCode() {	}
	/**
	 * @param width
	 * @param height
	 */
	public ImgCode(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	/**
	 * @param width
	 * @param height
	 * @param code_size
	 */
	public ImgCode(int width, int height, int code_size) {
		super();
		this.width = width;
		this.height = height;
		this.code_size = code_size;
	}
	/**
	 * @param codes
	 * @param width
	 * @param height
	 * @param code_size
	 * @param font_size
	 * @param lines
	 */
	public ImgCode(String codes, int width, int height, int code_size, int font_size, int lines) {
		super();
		this.codes = codes;
		this.width = width;
		this.height = height;
		this.code_size = code_size;
		this.font_size = font_size;
		this.lines = lines;
	}


	public Map<String, Object> code(){
		Map<String, Object> map = new HashMap<String, Object>();
		
		//画布
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
		
		//画噪点	写个最大值;然后随机0-1;
		int num = width*height/2;
		for (int i = 0; i < num ; i++) {
			img.setRGB((int)(Math.random()* width),(int) (Math.random()*height), (int)(Math.random()*0xEEEEEE));
		}
		
		//2D画笔
		Graphics2D g= img.createGraphics();
		//设置一个随机颜色;取浅色
		int rgb =(int)((Math.random()*0.5+0.5)*0xFFFFFF); 
		g.setColor(new Color(rgb));
		//设置字体
		g.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, font_size));
		
		//平滑抗锯齿
		g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		
		//获取随机到的验证码字符
		String code = randomCode();
		
		//绘制字符串
		g.drawString(code, 3+(int)(Math.random()*10), 27-(int)(Math.random()*10));
		
		//绘制5条干扰线
		for (int i = 0; i < lines; i++) {
			int x1 =(int)(Math.random()*80); 
			int x2 =(int)(Math.random()*80); 
			int y1 =(int)(Math.random()*30); 
			int y2 =(int)(Math.random()*30);
			g.setColor(new Color(rgb));
			g.drawLine(x1, y1, x2, y2);
		}
		
		map.put("code", code);
		map.put("image", img);
		return map;
	}
	
	/**
	 * 随机生成验证码字符
	 * @return 返回验证码字符串
	 */
	public String randomCode() {
		String str = codes;
		int size = code_size;
		//使用指针取值
		char[] code = new char[size];
		for (int i = 0; i < code.length; i++) {
			int index = (int)(Math.random()*str.length());
			code[i] = str.charAt(index);
		}
		return new String(code);
	}
	/**
	 * 测试方法
	 * @param args
	 */
	public static void main(String[] args) {
		OutputStream os = null;
		try {
			Map<String, Object> codeMap = new ImgCode().code();

			String code = (String)codeMap.get("code");
			System.out.println(code);
			BufferedImage img = (BufferedImage)codeMap.get("image");
			//创建一个Byte输出流
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			
			os = new FileOutputStream("d:/1.jpg");
			ImageIO.write(img, "png", out);
			//写出
			out.writeTo(os);
			byte[] buf = out.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
