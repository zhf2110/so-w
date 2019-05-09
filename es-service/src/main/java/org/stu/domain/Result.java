package org.stu.domain;

/**
 * @author zhangfeng542
 * @date 5/9/19
 */
public class Result<T>{

	private String code;

	private String message;

	private T data;

	public Result(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public Result(T data) {
		this.data = data;
		this.code = "0000";
		this.message = "secues";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
}
