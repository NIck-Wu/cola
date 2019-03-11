package com.server.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

		return userMapper.selectByPrimaryKey(user.getId());

	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
