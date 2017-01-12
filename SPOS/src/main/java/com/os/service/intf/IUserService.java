package com.os.service.intf;

import java.util.List;

import com.os.vo.User;

public interface IUserService {

	   public User selectUser(Long id);  
	     
	   public List<User> selectAll(); 
	   
	   public int insertSelective(User user);
	   public User selectByLoginId(String loginId); 
	
}
