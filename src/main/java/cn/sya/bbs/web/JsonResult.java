package cn.sya.bbs.web;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {
	private static final long serialVersionUID = 7111193894991604677L;
	//标记状态
	public static final int SUCCESS = 0;
	public static final int ERROR = 1;
	//状态标记
	private int state;
	//消息
	private String message;
	//数据T泛型,可以是任何具体的Object
	private T data;
	//默认无参构造器
	public JsonResult() {
	}
	
	//失败构造,传出异常
	public JsonResult(Exception e){
		this(ERROR, e.getMessage(), null);
	}
	//失败构造,传出异常信息
	public JsonResult(String errorMessage) {
		this(ERROR,errorMessage,null);
	}
	
	//成功构造,传出绑定信息
	public JsonResult(T data) {
		this(SUCCESS,"",data);
	}
	
	//状态码,信息
	public JsonResult(int state, String message) {
		this(state, message, null);
	}

	/**
	 * 成员变量构造器
	 * @param state
	 * @param message
	 * @param data
	 */
	public JsonResult(int state, String message, T data) {
		super();
		this.state = state;
		this.message = message;
		this.data = data;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public static int getSuccess() {
		return SUCCESS;
	}


	public static int getError() {
		return ERROR;
	}


	@Override
	public String toString() {
		return "JsonResult [state=" + state + ", message=" + message + ", data=" + data + "]";
	}
	
	
	
}
