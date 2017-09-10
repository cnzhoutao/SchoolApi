package com.zt.util;

import java.io.Serializable;
import java.util.Map;

/**
 * Ajax 响应 model
 * 
 * @author GJH 2017-03-07
 */
public class ApiResponse implements Serializable {

	private static final long serialVersionUID = -1408036643660271036L;

	/** An empty immutable <code>String</code> . */
	public static final String EMPTY_STRING = "";

	/** 成功状态码 */
	private static final int SUCCESS_CODE = 1;

	/** 成功返回消息 */
	private static final String SUCCESS_MSG = EMPTY_STRING;

	/** 失败状态码 */
	private static final int FAILURE_CODE = 0;

	/** 失败返回消息 */
	private static final String FAILURE_MSG = EMPTY_STRING;

	/** 成功返回结果对象 */
	private static final ApiResponse SUCCESS = new ApiResponse(SUCCESS_CODE,
			SUCCESS_MSG, null);

	/** 失败返回结果对象 */
	private static final ApiResponse FAILURE = new ApiResponse(FAILURE_CODE,
			FAILURE_MSG, null);

	/** 状态码 */
	private int code;

	/** 返回消息 */
	private String msg;

	/** 返回数据 */
	private Object data = new Object();

	private ApiResponse() {
	}

	/**
	 * AJAX请求的 JSON类型的返回值
	 * 
	 * @param code
	 *            状态码
	 * @param msg
	 *            返回消息
	 * @param data
	 *            返回数据
	 */
	private ApiResponse(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	/**
	 * 创建
	 * 
	 * @param code
	 *            状态码
	 * @return
	 */
	public static ApiResponse create(int code) {
		return new ApiResponse(code, EMPTY_STRING, null);
	}

	/**
	 * 创建
	 * 
	 * @param code
	 *            状态码
	 * @param msg
	 *            返回消息
	 * @return
	 */
	public static ApiResponse create(int code, String msg) {
		return new ApiResponse(code, msg, null);
	}

	/**
	 * 成功
	 * 
	 * @return
	 */
	public static ApiResponse success() {
		return SUCCESS;
	}

	/**
	 * 成功
	 * 
	 * @param data
	 *            数据
	 * @return
	 */
	public static ApiResponse success(Object data) {
		return new ApiResponse(SUCCESS_CODE, EMPTY_STRING, data);
	}

	/**
	 * 成功
	 * 
	 * @param msg
	 *            消息
	 * @param data
	 *            数据
	 * @return
	 */
	public static ApiResponse success(String msg, Object data) {
		return new ApiResponse(SUCCESS_CODE, msg, data);
	}

	/**
	 * 成功
	 * 
	 * @param code
	 *            状态码
	 * @param data
	 *            数据
	 * @return
	 */
	public static ApiResponse success(int code, Object data) {
		return new ApiResponse(code, EMPTY_STRING, data);
	}

	/**
	 * 成功
	 * 
	 * @param code
	 *            状态码
	 * @param msg
	 *            返回信息
	 * @param data
	 *            数据
	 * @return
	 */
	public static ApiResponse success(int code, String msg, Object data) {
		return new ApiResponse(code, msg, data);
	}

	/**
	 * 失败
	 * 
	 * @return
	 */
	public static ApiResponse failure() {
		return FAILURE;
	}

	/**
	 * 失败
	 * 
	 * @param msg
	 *            返回消息
	 * @return
	 */
	public static ApiResponse failure(String msg) {
		return new ApiResponse(FAILURE_CODE, msg, null);
	}

	/**
	 * 失败
	 * 
	 * @param msg
	 *            返回消息
	 * @param data
	 *            返回数据
	 * @return
	 */
	public static ApiResponse failure(String msg, Object data) {
		return new ApiResponse(FAILURE_CODE, msg, data);
	}

	/**
	 * 失败
	 * 
	 * @param code
	 *            状态码
	 * @param msg
	 *            返回消息
	 * @return
	 */
	public static ApiResponse failure(int code, String msg) {
		return new ApiResponse(code, msg, null);
	}

	/**
	 * 失败
	 * 
	 * @param code
	 *            状态码
	 * @param msg
	 *            返回消息
	 * @param data
	 *            数据
	 * @return
	 */
	public static ApiResponse failure(int code, String msg, Object data) {
		return new ApiResponse(code, msg, data);
	}
	
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("AjaxResponse {code: ").append(this.code)
			.append(", msg: ").append(this.msg)
			.append(", data: ").append(this.data)
			.append("}");
		return sb.toString();
	}

}
