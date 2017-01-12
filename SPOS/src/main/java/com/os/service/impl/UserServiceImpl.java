package com.os.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.dao.mapper.UserMapper;
import com.os.service.intf.IUserService;
import com.os.vo.User;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Autowired
	 private UserMapper userMapper;

	public User selectUser(Long id) {
		return userMapper.selectUser(id);
	}

	public List<User> selectAll() {
		return userMapper.selectAll();
	}

	public int insertSelective(User user) {
		
		return userMapper.insertSelective(user);
	}

	public User selectByLoginId(String loginId) {
		
		return userMapper.selectByLoginId(loginId);
	}

}
