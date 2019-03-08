package com.respons;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public class BaseIncHandlder {

	public static final String ENCODING_REQUEST = "UTF-8";

	/**
	 * 构造响应并输出 有数据体
	 * 
	 * @param dataObject
	 * @param response
	 * @param code
	 * @param msg
	 * @throws Exception
	 */
	public static void buildResponse(Object dataObject, HttpServletResponse response, String code, String msg)
			throws Exception {
		JSONObject data = new JSONObject();
		data.put("errorCode", code);
		data.put("errorMsg", msg);
		data.put("requestId", UUID.randomUUID().toString());
		if (dataObject != null)
			data.put("data", dataObject);
		SpringUtils.renderJson(response, data.toString());
	}

	/**
	 * 构造响应并输出 无数据体
	 * 
	 * @param response
	 * @param code
	 * @param msg
	 * @throws Exception
	 */
	public static void buildResponse(HttpServletResponse response, String code, String msg) throws Exception {
		JSONObject data = new JSONObject();
		data.put("errorCode", code);
		data.put("errorMsg", msg);
		data.put("requestId", UUID.randomUUID().toString());
		SpringUtils.renderJson(response, data.toString());
	}
}
