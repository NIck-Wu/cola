package com.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.entity.User;
import com.mapper.UserMapper;
import com.rabbitmq.Send.Sender;
import com.redis.RedisUtil;
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
	@Resource
	private RedisUtil rdRedisUtil;
	@Resource
	private Sender sender; // 死信队列發送者
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
		Object queryObj = rdRedisUtil.get(user.getId().toString());
		if (null == queryObj) {
			User userQuery = userMapper.selectByPrimaryKey(user.getId());
			if (null == userQuery) {
				return userQuery;
			}
			rdRedisUtil.set(user.getId().toString(), userQuery, 600);
			return userQuery;
		}
		return (User) queryObj;
	}

	/**
	 * 获取列表
	 */
	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 新增
	 */
	@Override
	public User save(User user) {
		JSONObject json = new JSONObject();
		Integer inseetStatus = userMapper.insert(user);

		if (1 == inseetStatus) {
			rdRedisUtil.set(user.getId().toString(), user, 200);
			json.put("userID", user.getId());
			sender.creatDeadTask(json);
		}
		return user;
	}

}
