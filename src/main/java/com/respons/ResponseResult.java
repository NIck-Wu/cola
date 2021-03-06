package com.respons;

import java.io.Serializable;
import java.util.UUID;

import com.constants.ErrorCodeEnum;



/**
 * 统一响应结果
 * @author lenovo
 *
 */
public class ResponseResult<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String requestId = null;
	
	private String errorCode = ErrorCodeEnum.SUCCESS.getCode();
	
	private String errorMsg = ErrorCodeEnum.SUCCESS.getDesc();
	
	private T data;
	

	public ResponseResult() {
		
	}

	public ResponseResult(T data) {
		this.data = data;
	}
	
	public ResponseResult(String errorCode, String errorMsg) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public ResponseResult(String errorCode, String errorMsg, T data) {
		super();
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.data = data;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = UUID.randomUUID().toString();
	}
	
	
	public boolean success(){
		return ErrorCodeEnum.SUCCESS.getCode().equals(this.errorCode);
	}
}
