package com.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ResponseResult;
import com.constants.ErrorCodeEnum;
import com.entity.User;
import com.rabbitmq.Send.Sender;
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
	 * @throws Exception
	 */
	@RequestMapping(value = "find", method = RequestMethod.POST)
	public ResponseResult<User> find(@RequestBody User user) throws Exception {
		User userQuery = userService.findById(user);
		return new ResponseResult<User>(ErrorCodeEnum.SUCCESS.getCode().toString(),
				ErrorCodeEnum.SUCCESS.getDesc().toString(), userQuery);
	}

	/**
	 * 測試RabbitMq
	 * 
	 * @return
	 */
	@RequestMapping(value = "rabbitmqDead", method = RequestMethod.POST)
	public String rabbitmqDead() {
		sender.creatDeadQueue();
		return "OK";
	}

}
