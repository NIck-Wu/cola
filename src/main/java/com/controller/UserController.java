package com.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.redis.RedisUtil;
import com.server.UserService;

@RestController
@RequestMapping("/api/user/user/")
public class UserController {
	
	private final static int ExpireTime = 60;   // redis中存储的过期时间60s
	@Resource
    private RedisUtil redisUtil;

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
		if (!redisUtil.hasKey(user.getId().toString())) {
			User userQuery = userService.findById(user);
			redisUtil.set(user.getId().toString(), String.valueOf(userQuery), ExpireTime);
			System.out.println("get data from Mysql ");
			return String.valueOf(userQuery);
		}
		String val = (String) redisUtil.get(user.getId().toString());
		System.out.println("get data from redis ");
		return val;
	}
}
