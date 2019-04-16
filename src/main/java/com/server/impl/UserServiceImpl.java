package com.server.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.constants.ErrorCodeEnum;
import com.entity.User;
import com.mapper.UserMapper;
import com.rabbitmq.Send.Sender;
import com.redis.RedisUtil;
import com.respons.ResponseResult;
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
	
	
	private static final int EXPER_TIME_REDIS= 1000 ; //redis缓存失效时间  10s
	@Resource
	private RedisUtil redisUtil;  //redis工具类
	@Resource
	private Sender sender; // 死信队列发送者
	@Autowired
	private UserMapper userMapper;

	/**
	 * 根据对象查询表信息
	 *
	 * @param user
	 * @return
	 */
	@Override
	public ResponseResult<User> findById(User user) {
		
		Object userByRedis = redisUtil.get(user.getId().toString());
		if (null == userByRedis) {
			User userQuery = userMapper.selectByPrimaryKey(user.getId());
			if (null == userQuery) {
				return new ResponseResult<User>(ErrorCodeEnum.SUCCESS.getCode(),ErrorCodeEnum.SUCCESS.getDesc());
			}
			redisUtil.set(user.getId().toString(), userQuery, EXPER_TIME_REDIS);
			return new ResponseResult<User>(ErrorCodeEnum.SUCCESS.getCode(),ErrorCodeEnum.SUCCESS.getDesc(),userQuery);
		}
		return new ResponseResult<User>(ErrorCodeEnum.SUCCESS.getCode(),ErrorCodeEnum.SUCCESS.getDesc(),(User) userByRedis);
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
		user.setCreatTime(new Date());
		user.setLastUpdate(new Date());
		userMapper.insert(user);
		return user;
	}

	/**
	 * 刪除
	 */
	@Override
	public void delete(User user) {
		Object queryObj = redisUtil.get(user.getId().toString());
		if (null == queryObj) {
			
		}
		redisUtil.del(user.getId().toString());
		userMapper.deleteByPrimaryKey(user.getId());
	}

}
