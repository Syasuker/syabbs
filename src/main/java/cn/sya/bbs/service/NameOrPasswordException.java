package cn.sya.bbs.service;

public class NameOrPasswordException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2442022274544928958L;

	/**
	 * 
	 */
	public NameOrPasswordException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NameOrPasswordException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NameOrPasswordException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public NameOrPasswordException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public NameOrPasswordException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
