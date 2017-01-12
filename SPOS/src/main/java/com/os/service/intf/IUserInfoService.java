package com.os.service.intf;

import java.util.List;

import com.os.base.vo.UserInfo;
import com.os.base.vo.UserInfoExample;

public interface IUserInfoService {
	
	 int insertSelective(UserInfo record);
	 List<UserInfo> selectByExample(UserInfoExample example);
	 UserInfo selectByPrimaryKey(Integer id);

}
