package com.controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.config.ValidateHelper;
import com.constants.ErrorCodeEnum;
import com.entity.User;
import com.rabbitmq.Send.Sender;
import com.respons.ResponseResult;
import com.server.UserService;

@RestController
@RequestMapping("/api/user/user/")
public class UserController {
	@Resource
	private Sender sender;
	@Autowired
	private UserService userService;
	/**
	 * 查询
	 * 
	 * @param user
	 * @return
	 * @return
	 * @throws IOException 
	 * @throws Exception
	 */
	@RequestMapping(value = "find", method = RequestMethod.POST)
	public ResponseResult<User> find(@RequestBody User user) throws IOException {
		
		ValidateHelper.validateNull(user, new String[] { "id" });
		
		return  userService.findById(user);
	}

	/**
	 * 新增
	 * 
	 * @return
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ResponseResult<User> save(@RequestBody User user) throws Exception {

		userService.save(user);

		return new ResponseResult<>(ErrorCodeEnum.SUCCESS.getCode().toString(),
				ErrorCodeEnum.SUCCESS.getDesc().toString(), user);
	}

	/**
	 * 新增
	 * 
	 * @return
	 */
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public ResponseResult<User> delete(@RequestBody User user) throws Exception {

		userService.save(user);

		return new ResponseResult<>(ErrorCodeEnum.SUCCESS.getCode().toString(),
				ErrorCodeEnum.SUCCESS.getDesc().toString(), user);
	}
	
}
