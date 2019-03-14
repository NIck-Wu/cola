package com.pay.wechatpay.controller.service;

import com.ResponseResult;
import com.alibaba.fastjson.JSONObject;

public interface WeChatPayService {
	
//	/**
//	 * 微信支付回调
//	 * @param request
//	 * @return
//	 */
//	public String wechatPayAsynNotify(HttpServletRequest request);
//	/**
//	 * app下单
//	 * @param request
//	 * @return
//	 */
//	public ResponseResult<JSONObject> appPushOrder(JSONObject request);
//	/**
//	 * h5下单
//	 * @param request
//	 * @return
//	 */
//	public ResponseResult<JSONObject> h5PushOrder(JSONObject request);
//	/**
//	 * 微信公众号下单
//	 * @param request
//	 * @return
//	 */
	public ResponseResult<JSONObject> jsAPIPushOrder(JSONObject request);
//	/**
//	 * 微信订单查询
//	 * @param request
//	 * @return
//	 */
//	public ResponseResult<JSONObject> orderQuery(JSONObject request);
//	/**
//	 * 关闭订单
//	 * @param request
//	 * @return
//	 */
//	public ResponseResult<JSONObject> closeOrder(JSONObject request);
//	/**
//	 * 微信退款
//	 * @param request
//	 * @return
//	 */
//	public ResponseResult<JSONObject> orderRefund(JSONObject request);
//	/**
//	 * 微信退款查询
//	 * @param request
//	 * @return
//	 */
//	public ResponseResult<JSONObject> refundQuery(JSONObject request);
//	/**
//	 * 微信退款结果通知回调
//	 * @param request
//	 * @return
//	 * @throws Exception
//	 */
//	public String refundAsynNotify(HttpServletRequest request) throws Exception;
//	
//	public ResponseResult<JSONObject> downloadBill(@RequestBody JSONObject request);

}
