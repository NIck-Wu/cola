package com.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.User;
import com.mapper.UserMapper;
import com.server.UserService;

/**
 *
 * 表服务实现
 *
 * @author
 * @version 1.0
 * @date 2018-11-13 12:20:29
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	private final static int ExpireTime = 60; // redis中存储的过期时间60s
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	@Autowired
	private UserMapper userMapper;

	/**
	 * 根据对象查询表信息
	 *
	 * @param user
	 * @return
	 */
	@Override
	public User findById(User user) {
		ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
		Object userQueryRedis = opsForValue.get(String.valueOf(user.getId()));
		if (null == userQueryRedis) {
			User userQuery = userMapper.selectByPrimaryKey(user.getId());
			if (null == userQuery) {
				return userQuery;
			}
			opsForValue.set(userQuery.getId().toString(), userQuery, ExpireTime);
			return userQuery;
		}
		return (User) userQueryRedis;
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
