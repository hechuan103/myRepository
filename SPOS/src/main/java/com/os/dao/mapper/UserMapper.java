package com.os.dao.mapper;

import java.util.List;

import com.os.vo.User;

public interface UserMapper {
	
	public List<User> selectAll();
	
	public User selectUser(Long id);
	
	public int insertSelective(User user);
	
	public User selectByLoginId(String loginId);

}
