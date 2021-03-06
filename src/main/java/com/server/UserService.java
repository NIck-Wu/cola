package com.server;

import java.util.List;

import com.entity.User;
import com.respons.ResponseResult;

public interface UserService {

	/**
	 * 查询
	 * 
	 * @param user
	 * @return
	 */
	public ResponseResult<User> findById(User user);

	/**
	 * 列表
	 * 
	 * @return
	 */
	public List<User> list();

	/**
	 * 新增
	 * 
	 * @param user
	 * @return
	 */
	public User save(User user);
	
	/**
	 * 删除
	 * @param user
	 */
	public void delete(User user); 
}
