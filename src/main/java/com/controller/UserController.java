package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.server.UserService;

@RestController
@RequestMapping("/api/user/user")
public class UserController {

	@Autowired
	private StringRedisTemplate template;

	@Autowired
	private UserService userService;

	/**
	 * 查询
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "find", method = RequestMethod.POST)
	public String find(@RequestBody User user) {
		// 没有这个key
		if (!template.hasKey(user.getId().toString())) {
			User userQuery = userService.findById(user);
			template.opsForValue().append(user.getId().toString(), String.valueOf(userQuery));
			System.out.println("get data from Mysql ");
			return String.valueOf(userQuery);
		}
		String val = template.opsForValue().get(user.getId().toString());// 根据key获取缓存中的val
		System.out.println("get data from redis ");
		return val;
	}
}
