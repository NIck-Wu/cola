package com.server;

import com.entity.User;

public interface UserService {

	/**
	 * 查询
	 * 
	 * @param user
	 * @return
	 */
	public User findById(User user);
}
